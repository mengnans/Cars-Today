## Description
This is the repo for Mengnan Shi and Ye Yan for the uni project called "Cars Today".

Cars Today is a website for users to buy brand new cars or second-hand cars. Registered sellers can also sell their cars on our website.

We have designed different views for users and administrators, and they can be switched by the nav bar on the top.

## Test Scenario
### User name and password
#### Administrator
The initial super admin name is **root**, and the password is **5314**.

**Note that:**
The login page for admin user is https://whispering-oasis-77503.herokuapp.com/admin/login
#### Normal user
You can create your own user on https://whispering-oasis-77503.herokuapp.com/sign-up.jsp

Or

You can use this account: username is **test**, password is **test**.

**Note that:**
The login page for the normal user is https://whispering-oasis-77503.herokuapp.com/login

### Role explanation

#### Administrator
The administrator is mainly responsible for CRUD new cars.

#### Normal user
Normal users can purchase new cars.

Once the purchase is done, users can check their order in the My Order Tab.

**Feature B update:**

Normal users can bid used cars.

Normal users can check their bid in the My Bid Tab.

Normal users can create/edit/close auction for their used cars.

Normal users can check their auctions in the Sell My Car tab.

### Sample scenarios

#### The administrator creates a new car
The administrator comes to the website, then clicks Admin Mode, which will navigate to the admin login page. Then the administrator login.
After that, he clicks Add New Car button, and after filling out some necessary car details, he The administrator submit. Finally, a new car
has been created, and it can be purchased by users.

#### A new user buys a new car
A new user comes to the website, he/she firstly sign-up his/her account, and then login to the website. After that, he/she checks all the car
listed on our home page. Then decide to buy Bentley Bentayga, he/she click the "Bentley Bentayga" button, and it will go to the detail page
for the Bentley Bentayga car. Then the user clicks buy now, it will go to the purchase page. The user will need to fill out some necessary
information (e.g. phone and address). Then a order will be created for the user, which he/she can check later at the My Order tab.

#### A registered user creates an auction
A registered user comes to the website, he/she first goes to sell my car tab, then clicks add a new car button. After filling out all the 
necessary car details, he/she has created a new auction. He/she can check this auction later in Sell My Car tab.

#### A registered user bids a used car
A registered user comes to the website, he/she clicks one of the used cars on our home page. It will go to the car detail page.
Then, the user clicks Bid Now Button, and fills out his/her phone/address/bid price, he/she has created a new bid. He/she can check this
bid later in the My Bid tab.

#### A registered user closes his/her auction
A registered user comes to the website, he/she first goes to Sell My Car tab, then he clicks Close Auction button to one of his/her cars
that he/she wanted to close the auction. Then the auction is closed, the website will show the result of the auction (e.g. winner with price 
or no valid bids). After that, for those users who bid the car, the status of their bids will be changed (for the winner it will be changed 
to a successful bid, for the others it will be changed to failed bid).
Meanwhile, a new order will be created for the winner.