db = connect('mongodb://localhost:27017/MongEat')
db.dropDatabase()

const articlesStub = require('./Articles.json')
const ordersStub = require('./Orders.json')
const restaurantsStub = require('./Restaurants.json')
const usersStub = require('./users.json')


print('Insertion des articles.')
print(db.Articles.insertMany(articlesStub))

print('Insertion des utilisateurs.')
print(db.Users.insertMany(usersStub))

// print('Insertion des commandes.')
// print(db.Orders.insertMany(ordersStub))

// print('Insertion des restaurants.')
// print(db.Restaurant.insertMany(restaurantsStub))