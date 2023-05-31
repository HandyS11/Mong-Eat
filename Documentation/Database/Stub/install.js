db = connect('mongodb://localhost:27017/MongEat')
db.dropDatabase()

const articlesStub = require('./Articles.json')
print('Inserting articles...')
db.Articles.insertMany(articlesStub)

const usersStub = require('./users.json')
print('Inserting users...')
db.Users.insertMany(usersStub)

const ordersStub = require('./Orders.json')
// print('Inserting orders...')
// db.Orders.insertMany(ordersStub)

const restaurantsStub = require('./Restaurants.json')
// print('Inserting restaurants...')
// db.Restaurant.insertMany(restaurantsStub)

print('Installation finished')