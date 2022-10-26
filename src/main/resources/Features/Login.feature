Feature: user should be able to login to the system

  #test scenario 1
  Scenario:user login with valid username and pass
    Given user open browser
    And  user navigates to login page

    When user enter "tomsmith" and "SuperSecretPassword!"
    And user click on login button

    #expected result
    Then user can login successfuly and enter the login page
    And  user go to home page


    Scenario:user login with invalid username and pass

      Given user open browser
      And  user navigates to login page

      When user enter "lll" and "2000"
      And user click on login button

    #expected result
      Then user could not login
