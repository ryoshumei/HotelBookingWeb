
# RELEASENOTES (v3.0) for HotelBookingWeb

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
