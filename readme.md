### Inventory

This inventory app is the same as the version that is included in my repository called CAEWeb. I wanted to try to re-implement the server side portion of this app using a different language, so I re-wrote the API for this app using Java's Spring and Hibernate Frameworks. Because this is a whole web application, Spring MVC was used to make it a fully functional web application.

Note: I was learning how to use Spring and Hibernate when I made this, so there are things here that may not be the best practice. It should also be noted that I wrote the API to work with the existing written javascript portion of the application. Because of that, there were some design decisions that are not ideal. Although these decisions work fine for a language such as PHP, they are not ideal for Java, and as such have caused me to do some unconventional things in order to make it fully operate without altering the JS. Given more time, I would alter the JS side to better handle Java conventions and make the application better written.

#### Current Inventory

The current inventory tab shows all of the items that the CAE Center is tracking, and the assoicated quantities of each item. There is information about the email threshold, and on order quantity as well. Next to the quantity there are increment and decrement buttons. Clicking them changes the inventory automatically and persists that data to the server. Double clicking on a row of an item will open up a modal box where the details of the item can be edited. The modal box can be closed by clicking either save or cancel. If a new item needs to be added to the system, the user can click the add new button. This will open a different but similar modal box that will allow the user to fill out the appropriate information. Once filled out the user can click save to add the new item, or cancel to return to the inventory listing.

#### View Orders

The view orders tab allows a user to see all of the orders that have ever been placed. It shows which vendor the order was for, and if it is open or not, as well as the number of items that were ordered. Double clicking the row of information for the order will open up a modal box displaying the details of the order, as well as a list of what was ordered. If the order is an open order, the modal box will give an option to accept the order. Accepting the order will close out the order and automatically update the quantities for the items in the order to current quantites plus the ordered amount.

#### Place Orders

The place orders tab shows the exact same information as the current inventory tab, however in place of the quanitity spot is a textbox that can be filled out to place an order. When the fields are filled out, and the place order button is clicked, the system will create a new order for each vendor that items are being ordered from. The system does not currenlty send the order somewhere. It simply creates the order in the system. Future plans are to either have the order emailed to an account, or integrate it with some other ordering system. Once and order is submitted, the system will then switch tabs to the view orders tab so that the user can see the newly created orders. In addition to all of these updates, the items will update the on order quantity to show that there are more on the way.

#### View Log

The view log tab shows all of the transactions that have occurred during the use of the system. It sorts the log in reverse chronological order with the most recent transactions at the top. The system also tries to lump any transactions that occur at the same time into a single log. (ie. If say the decrement button is pressed 3 times, rather than logging that the item was decremented by 1, 3 times, it will attempt to see that the actions were performed at relatively the same time, and group them into a single log entry showing 1 decrement of 3.) This may not always work since it does this work by setting a timeout to fire after a few seconds and do the logging. If the increment or decrement are clicked before the timeout fires, the timeout is reset and starts the countdown over. Once the timer actually runs out, the log is fired, and the log reflects how many transactions occurred.

## Database Information
### Database Name
By default the name of the database is: 

caewebspring

This can easily be changed if needed in the hibernate configuration XML file.

### Tables

All of the table structure has been listed below for reference. There is a .sql file in the root of this project that can be used to populate the database.

#### item

| Field               | Type             | Null | Key | Default             | Extra          |
|---------------------|------------------|------|-----|---------------------|----------------|
| id                  | int(10) unsigned | NO   | PRI | NULL                | auto_increment |
| name                | varchar(25)      | NO   |     | NULL                |                |
| description         | varchar(100)     | NO   |     | NULL                |                |
| quantity            | int(11)          | NO   |     | NULL                |                |
| vendor_id           | int(11)          | NO   |     | NULL                |                |
| email_threshold     | int(11)          | NO   |     | NULL                |                |
| item_url            | varchar(150)     | NO   |     | NULL                |                |
| on_order_quantity   | int(11)          | NO   |     | NULL                |                |
| active              | tinyint(1)       | NO   |     | NULL                |                |
| created_at          | datetime         | NO   |     | NULL                |                |
| updated_at          | datetime         | NO   |     | NULL                |                |

#### order_item

| Field               | Type             | Null | Key | Default             | Extra          |
|---------------------|------------------|------|-----|---------------------|----------------|
| id                  | int(10) unsigned | NO   | PRI | NULL                | auto_increment |
| order_id            | int(11)          | NO   |     | NULL                |                |
| item_id             | int(11)          | NO   |     | NULL                |                |
| order_qty           | int(11)          | NO   |     | NULL                |                |
| created_at          | datetime         | NO   |     | NULL                |                |
| updated_at          | datetime         | NO   |     | NULL                |                |

#### orders

| Field               | Type             | Null | Key | Default             | Extra          |
|---------------------|------------------|------|-----|---------------------|----------------|
| id                  | int(10) unsigned | NO   | PRI | NULL                | auto_increment |
| status              | smallint(6)      | NO   |     | NULL                |                |
| created_at          | datetime         | NO   |     | NULL                |                |
| updated_at          | datetime         | NO   |     | NULL                |                |

#### trans_log

| Field               | Type             | Null | Key | Default             | Extra          |
|---------------------|------------------|------|-----|---------------------|----------------|
| id                  | int(10) unsigned | NO   | PRI | NULL                | auto_increment |
| username            | varchar(30)      | NO   |     | NULL                |                |
| itemname            | varchar(25)      | NO   |     | NULL                |                |
| action              | varchar(255)     | NO   |     | NULL                |                |
| created_at          | datetime         | NO   |     | NULL                |                |
| updated_at          | datetime         | NO   |     | NULL                |                |

#### vendor

| Field               | Type             | Null | Key | Default             | Extra          |
|---------------------|------------------|------|-----|---------------------|----------------|
| id                  | int(10) unsigned | NO   | PRI | NULL                | auto_increment |
| name                | varchar(20)      | NO   |     | NULL                |                |
| url                 | varchar(150)     | NO   |     | NULL                |                |
| created_at          | datetime         | NO   |     | NULL                |                |
| updated_at          | datetime         | NO   |     | NULL                |                |
