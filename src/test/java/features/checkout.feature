Feature: Search and place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> Items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom |
