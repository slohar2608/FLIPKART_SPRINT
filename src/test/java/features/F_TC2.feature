Feature:Delete

Scenario Outline: Verify user can remove product from wishlist

Given User is login "<name>" and "<pass>"
And Open the wishlist page
When Click on delete button and cancel
And Product should not be deleted
And Click on yes,confirm
Then Product should be deleted

Examples:
 | name                  | pass          |   
 | ssl94201569@gmail.com |    shivani@1  |