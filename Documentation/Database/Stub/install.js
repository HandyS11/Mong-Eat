const { ArticlesStub } = require('./Articles')
const { UsersStub } = require('./Users')
const { RestaurantsStub } = require('./Restaurants')
const { OrdersStub } = require('./Orders')

db = connect('mongodb://localhost:27017/MongEat')
db.dropDatabase()

print('Inserting articles...')
db.Articles.insertMany(ArticlesStub)

print('Inserting users...')
db.Users.insertMany(UsersStub)

print('Inserting restaurants...')
db.Restaurant.insertMany(RestaurantsStub)

print('Inserting orders...')
db.Orders.insertMany(OrdersStub)

print('Installation finished')