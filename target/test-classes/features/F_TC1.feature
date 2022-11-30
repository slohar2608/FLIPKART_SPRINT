Feature: Wishlist icon


Background: common steps
Given Open the browser

Scenario Outline: Verify user can click on wishlist icon

Given user is able to login "<username>" and "<password>"
And User enters "<search>" in search box
When  click on wishlist icon
And Wishlist icon should be clickable 
Then confirmation message should be displayed
And Product should be Added in wishlist 
Examples:
      | username              | password      |   search  | 
      | ssl94201569@gmail.com |    shivani@1  | macbook   |

