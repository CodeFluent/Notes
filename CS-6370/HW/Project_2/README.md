Project 2

Group: Wasfi Momen

Notes:

    - does have superuser root. There is only one superuser.
    - root is not different than any registered user (didn't get time to add more functionality).
    - guests can only view content, users can view and add content.

Known Issues:

    - User registration creates duplicate records in database since the form submits to the same php page it is on. Need a Post-Redirect-Get Pattern.
    - Blog submissions occur twice due to same reason.
    - User logins probably happen twice also.
