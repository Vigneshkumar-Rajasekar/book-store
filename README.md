# book-store
Software solution for automating the purchasing and checkout process of a bookshop

1. Enter your book details in bookrepo.json file to load and play as book master.
2. To check the testcases, added 5 test data files (jsons). You can modify and test the cases.
3. Given a runnable OrderEntry to test the checkout and discount functionalities as standalone.
4. Use orderdetail.json file to modify the order and run the OrderEntry class to get the total cost of the order.

Additional Implementations
1. Added quantity parameter in the order object to fulfill the order requirement

Suggestions:
1. Discounts can be set to be data driven in db, so it can be configured in backend without any code change.
2. Can add unique key (sku) for every book, so it can be manipulated using the key instead of book name.