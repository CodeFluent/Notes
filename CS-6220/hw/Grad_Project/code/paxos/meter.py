import time

import practical

from practical import ProposalID


class SubStation (practical.Proposer):
    """
    The proposer class of meter.py. The SubStation class is the one that proposes
    privacy values to send to all SmartMeter acceptors.
    """

    active = True
    leader = False

    proposed_value = None
    proposal_id = None
    highest_accepted_id = None
    promises_received = None
    nacks_received = None
    current_prepare_msg = None
    current_accept_msg = None

    def __init__(self, network_uid, quorum_size):
        self.network_uid = network_uid
        self.quorum_size = quorum_size
        self.proposal_id = ProposalID(0, network_uid)
        self.highest_proposal_id = ProposalID(0, network_uid)
        print("Substation peer id: ", self.network_uid)

    def propose_value(self, value):
        '''
        Sets the proposal value for this node iff this node is not already aware of
        a previous proposal value. If the node additionally believes itself to be
        the current leader, an Accept message will be returned
        '''
        if self.proposed_value is None:
            self.proposed_value = value

            if self.leader:
                self.current_accept_msg = Accept(
                    self.network_uid, self.proposal_id, value)
                return self.current_accept_msg

    def prepare(self):
        '''
        Returns a new Prepare message with a proposal id higher than
        that of any observed proposals. A side effect of this method is
        to clear the leader flag if it is currently set.
        '''

        self.leader = False
        self.promises_received = set()
        self.nacks_received = set()
        self.proposal_id = ProposalID(
            self.highest_proposal_id.number + 1, self.network_uid)
        self.highest_proposal_id = self.proposal_id
        self.current_prepare_msg = Prepare(self.network_uid, self.proposal_id)

        return self.current_prepare_msg

    def receive_nack(self, msg):
        '''
        Returns a new Prepare message if the number of Nacks received reaches
        a quorum.
        '''
        self.observe_proposal(msg.promised_proposal_id)

        if msg.proposal_id == self.proposal_id and self.nacks_received is not None:
            self.nacks_received.add(msg.from_uid)

            if len(self.nacks_received) == self.quorum_size:
                return self.prepare()  # Lost leadership or failed to acquire it

    def receive_promise(self, msg):
        '''
        Returns an Accept messages if a quorum of Promise messages is achieved
        '''
        self.observe_proposal(msg.proposal_id)

        if not self.leader and msg.proposal_id == self.proposal_id and msg.from_uid not in self.promises_received:

            self.promises_received.add(msg.from_uid)

            if msg.last_accepted_id > self.highest_accepted_id:
                self.highest_accepted_id = msg.last_accepted_id
                if msg.last_accepted_value is not None:
                    self.proposed_value = msg.last_accepted_value

            if len(self.promises_received) == self.quorum_size:
                self.leader = True

                if self.proposed_value is not None:
                    self.current_accept_msg = Accept(
                        self.network_uid, self.proposal_id, self.proposed_value)

        return self.current_accept_msg


class SmartMeter (practical.Acceptor):
    """
    The acceptor class of meter.py. The SmartMeter class is the one that accepts
    privacy values and decides whether to reject or accept them.
    """

    active = True

    def __init__(self, network_uid, promised_id=None, accepted_id=None, accepted_value=None):

        self.network_uid = network_uid
        self.promised_id = promised_id
        self.accepted_id = accepted_id
        self.accepted_value = accepted_value
        print("SmartMeter peer id:", self.network_uid)

    def receive_prepare(self, msg):
        if msg.proposal_id >= self.promised_id:
            self.promised_id = msg.proposal_id
            return Promise(self.network_uid, msg.from_uid, self.promised_id, self.accepted_id, self.accepted_value)
        else:
            return Nack(self.network_uid, msg.from_uid, msg.proposal_id, self.promised_id)

    def receive_accept(self, msg):
        if msg.proposal_id >= self.promised_id:
            self.promised_id = msg.proposal_id
            self.accepted_id = msg.proposal_id
            self.accepted_value = msg.proposal_value
            return Accepted(self.network_uid, msg.proposal_id, msg.proposal_value)
        else:
            return Nack(self.network_uid, msg.from_uid, msg.proposal_id, self.promised_id)


def main():
    PRIVACY_VALUE_TO_CONCEDE = .2
    a = SubStation(1, 2)
    b = SmartMeter(3)
    c = SmartMeter(2)
    a.propose_value(.1)


if __name__ == '__main__':
    main()
