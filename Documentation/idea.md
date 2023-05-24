# Mong-eat

**OUT DATED** pls refer to the read me

## Collections

```mongodb
Restaurants {
	_id: ObjectId,
	name: string,
	image: string,
	categories: [ 
		{
			name: string,
			image: string
		}
	],
	rate: double,
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

Articles {
	_id: ObjectId,
	name: string,
	image: string,
	price: double
}

Orders {
	_id: ObjectId,
	status: string,
	oldprice: double,
	reduction: double,
	fee: double,
	price: double,
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

Users {
	_id: ObjectId,
	firstname: string,
	lastname: string,
	location: [
		{
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
	]	
}
```