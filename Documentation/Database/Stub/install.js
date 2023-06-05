import UsersStub from "./Users.js"
import ArticlesStub from "./Articles.js"
import RestaurantsStub from "./Restaurants.js"
import OrdersStub from "./Orders.js"

db = connect('mongodb://localhost:27017/MongEat')
db.dropDatabase()

print('Inserting users...')
db.Users.insertMany(UsersStub)

print('Inserting articles...')
db.Articles.insertMany(ArticlesStub)

print('Inserting restaurants...')
db.Restaurant.insertMany(RestaurantsStub)

print('Inserting orders...')
db.Orders.insertMany(OrdersStub)

print('Installation finished')