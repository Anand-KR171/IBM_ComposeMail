Feature: To Send an Email

Background:
Given we should be in the home page
 
Scenario Outline: To test Login with valid scenario
When Enter the valid name "<user>"
And Enter the valid password "<pwd>"
And Click on the Validbutton
And I see the name as "<email>"
And go to compose
And Enter the send to
And Enter the subject
And Add the body message "<msg>"
Then Click on send message

Examples: 
|user|pwd|email|msg|
|AnandKR1IBM|10April5083@|anankr1@in.ibm.com|Hello Mr. Naveen \n      This is for Testing \n\n From, \n Anand KR|