import time

from paxos import practical

from paxos.practical import ProposalID

MAJORITY = 2


class MeterMessenger (practical.Messenger):

    def send_prepare_nack(self, to_uid, proposal_id, promised_id):
        """
        NACK message from practical.py. Used to prepare a NACK message.
        """

    def send_prepare_ack(self, to_uid, proposal_id, promised_id):
        """
        ACK message from practical.py. Used to prepare an ACK message.
        """

    def on_resolution(self, proposal_id, value):
        """
        Resolution on privacy parameter.
        """

class SubStation (practical.Node):
    """
    The proposer class of meter.py. The SubStation class is the one that proposes
    privacy values to send to all SmartMeter acceptors.
    """
    active = True

    def __init__(self, messenger, uid, quorum_size):

        super(SubStation, self).__init__(messenger, uid, quorum_size)

        self.


class SmartMeter (practical.Node):
    """
    The acceptor class of meter.py. The SmartMeter class is the one that accepts
    privacy values and decides whether to reject or accept them.
    """

    active = True

    