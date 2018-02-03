package sample;

public class SubmissionController {

    private SubmissionModel model = null;

    public SubmissionController (SubmissionModel model) {
        this.model = model;
    }

    public void updateTxtSrc(String input) {
        System.out.println("RAN2");
        model.setTxtSrc(input);
    }

}
