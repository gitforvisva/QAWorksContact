@contact
Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide my name "j.Bloggs" email "j.Bloggs@qaworks.com" and message  "please contact me I want to find out more"
    And send the details
    Then I should see Message "Your Message Successfully Sent"

  Scenario: Blank Name Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide invalid details  in name "     " email "j.Bloggs@qaworks.com " and message  "please contact me I want to find out more"
    And send the details
    Then I should see Error Message for Blank Name "Your name is required"

  Scenario: Blank Email Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide invalid details  in name "j.Bloggs" email "       " and message  "please contact me I want to find out more"
    And send the details
    Then I should see Error Message for Blank Email "An Email address is required"


  Scenario: Blank Message Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide invalid details  in name "j.Bloggs" email "j.Bloggs@qaworks.com " and message  "            "
    And send the details
    Then I should see Error Message for Blank Message "Please type your message"

  Scenario Outline: InValid Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide invalid name "<Name>" email "<Email>" and message  "<Message>"
    And send the details
    Then I should see Error Message for Invalid Details "Please Enter Valid details"
    Examples:
      | Name   | Email    | Message                                   |
      | ££££££ | £$%^&&&@ | please contact me I want to find out more |
      | 123456 | qwerty   | please contact me I want to find out more |

  Scenario Outline: InValid Submission
    Given I am on the QAWorks Site
    When I navigate to Contact Page
    Then I should be in the Contact Page
    When I provide invalid name "<Name>" email "<Email>" and message  "<Message>"
    And send the details
    Then I should see Error Message for InvalidEmail "Invalid Email Address"
    Examples:
      | Name     | Email   | Message                                   |
      | j.Bloggs | 1@123.c | please contact me I want to find out more |
      | j.Bloggs | 1@1.c   | please contact me I want to find out more |




