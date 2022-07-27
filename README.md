# Library-Management-System-Phase2

**Gabriela**
- Room
- Checkedoutroom

**Gavin**
- Patron
- Request
- Librarian
- APISecurity and UserInfo

**Ian**
- Event
- Fee

**Jakob**
- Checkedoutbook
- Checkedoutvideo
- Book
- Video

## APIs

### Librarian (Role)

**Book/Video**
- View video and book collections(GET)
- Add/remove books(POST and DELETE)
- Add/remove videos (POST and DELETE)

**Rooms**
- View room collections(GET)
- View scheduled rooms (GET)

**Patrons**
- View patrons (GET)
- Register patrons (POST)
- Remove patrons(DELETE)
- Update patron balance (PUT)
- Renew library card (PUT)

**Events** 
- View Events(GET)
- add/remove/edit (POST, DELETE and PUT)

**Requests**
- View book requests (GET)
- Complete book requests (POST and DELETE)

### Patron (Role)

**Book/Video**
- View video and book collections(GET)
- Check out books (POST)
- Check out videos (POST)
- Search for books / videos? (GET)
		
**CheckedoutBook/Video**
- View checked out books/videos (GET)
- View/pay overdue books/videos (GET and PUT)
- Return books/videos (DELETE)
- Check out videos (POST)

**Requests**
- Submit book requests (POST)

**Rooms**
- View room collections (GET)
- View scheduled rooms (GET)
- Reserve room based on number (POST)
