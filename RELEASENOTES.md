
# RELEASE NOTE (v3.0) for HotelBookingWeb

## [3.0] - 2023-08-03

### General Updates

- **Database Updates**: The database structure has been updated for extensibility. New tables, such as the "instruction" and "deleted_order_table," have been added. The "order_table" now includes price information.
- **Service Layer Refactoring**: The service layer has been refactored with interfaces and implementation, leading to improved maintainability and reliability.

### User Updates

- **Multiple Room Booking**: Users can now book multiple rooms at once.
- **Default Gender Selection**: A default gender selection has been added for convenience during booking.
- **Improved Gender Display**: The gender field in the booking confirmation is now displayed as a string ("male" or "female") instead of a number.

### Admin Updates

- **Improved Gender Display**: The gender field in the guest orders overview is now displayed as a string ("male" or "female") instead of a number.
- **Payment Status Check**: Admins can now check if a guest has paid for their order and mark the order as paid.

### Important Information

- **Deleted Orders**: Deleted orders will now be saved in the "deleted_order_table" for auditing and data recovery purposes.


# RELEASE NOTE (v2.0) for HotelBookingWeb

## [2.0] - 2023-03-26

## Release Date
26th March 2023

## Highlights

In this release, we have made some major updates, including an overhaul of the front-end interface, introduction of FormValidation, addition of a BookingComplete page, and implementation of SpringSecurity with LoginForm for admin access. These improvements aim to enhance the usability and security of the platform.

## Detailed Updates

### Frontend Overhaul - Version 2.0
- Date: 26th March 2023
- A significant update has been made to the front-end interface, improving usability and user experience.

### Addition of BookingComplete Page
- Date: 1st March 2023
- A new BookingComplete page has been added, providing users with a detailed summary and confirmation of their booking.

### Enhanced Admin Access
- Date: 26th February 2023
- Admin pages can now be accessed through newly added buttons, improving the flow between the checkGuests and checkRooms pages.

### SpringSecurity with LoginForm for Admin Login
- Date: 24th February 2023
- Added a new LoginForm for admin login using SpringSecurity, enhancing the security of the system. Two admin test cases with hashed passwords in the database have been added. Test details are as follows:
    - Admin ID : test1, Password: test1
    - Admin ID : test2, Password: test2
    - Admin login page : "http://localhost:8090/admin"
    - Admin pages :
        - "http://localhost:8090/admin/checkGuests"
        - "http://localhost:8090/admin/checkRooms"

### FormValidation in FrontEnd with Javascript
- Date: 19th February 2023
- FormValidation has been added to the front-end, ensuring users input data correctly and improving the overall data quality.



