# Mong-eat

...

## Getting started

...

## API

...

## MongoDB

### Collections

#### Restaurant
```mongodb
Restaurant {
	_id: ObjectId,
	name: string,
	image: string,
    rate: double,
	categories: [ 
		{
			name: string,
			image: string
		}
	],	
	location: {
		point: {
			x: double,
			y: double
		},
		address: {
			country: string,	
			city: string,
			road: string
		}
	}
}
```
**Notes:**

- **_id**: Default mongo id
- **name**: Restaurant name
- **image**: Url of an image
- **rate**: User note *(average)*
- **categories**: List of "Category" object that represent a restaurant style. <u>ex:</u> 
*Pizza*, *Fast-food*, ...
- **location**: [see the special objects..](####Location)

#### Articles
```mongodb
Articles {
	_id: ObjectId,
	name: string,
	image: string,
	price: double
}
```
**Notes:**

- **_id**: Default mongo id
- **name**: Article name
- **image**: Url of an image
- **price**: Default article price *(no reductions)*

#### Orders
```mongodb
Orders {
	_id: ObjectId,
	status: string,
	price: double,
    tip: double,
	reduction: double,
	fee: double,
	articles: [Articles._id],
	owner: Users._id
	location: {
		point: {
			x: double,
			y: double
		},
		address: {
			country: string,	
			code: int,
			city: string,
			road: string
		}
	}
}
```
**Notes:**

- **_id**: Default mongo id
- **status**: Status of the order <u>ex:</u> *OnGoing*, *Done*, *Cancelled* ...
- **price**: Default price of the article
- **tip**: Tip given to the delivery man
- **reduction**: Percentage over the price
- **fee**: Total price of the order
- **articles**: [see the Articles collection](####Articles)
- **owner**: [see the Users collection](####Users)
- **location**: [see the special objects..](####Location)

### Special objets

#### Location
```mongodb
{
	point: {
		x: double,
		y: double
	},
	address: {
		country: string,	
		city: string,
		road: string
	}
}
```
**Notes:**

- **point**
    * **x**: Latitude
    * **y**: Longitude
- **address**
    * **country**: Country *(string only)*
    * **city**: City *(string only)*
    * **road**: Detail of the address


## Credits

* Co-author [Mathis Ribémont](https://github.com/TEDDAC)
* Co-author [Valentin Clergue](https://github.com/HandyS11)