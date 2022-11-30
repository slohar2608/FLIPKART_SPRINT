Feature: Wishlist

Scenario Outline: Check user is not able to add product in wishlist withput login.
Given Search product "<Pname>"
When Login page should be displayed
Then Product should not be added in wishlist
Examples:
|Pname|
|shoes|