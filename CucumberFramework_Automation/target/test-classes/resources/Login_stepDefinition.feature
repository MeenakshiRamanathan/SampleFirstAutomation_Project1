Feature: Login

    Scenario: Successful login with valid credentials
        Given the user is on the login page
        When the user enters a valid username "<username1>" and password "<password1>"
        Then the user clicks the login button
        When I log in to Gmail and enter username2 "a98070294@gmail.com" and password2 "Annam#1990"
        Then Pass the otp value
        And Verify login success
     Examples:  
       | username1             |password1     |            
       
       | a98070294@gmail.com   |Annam#1990    |
       