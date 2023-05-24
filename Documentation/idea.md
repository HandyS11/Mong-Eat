# Mongol-eat

## Collections

```mongodb
Shops {
	_id: ObjectId,
	name: string,
	image: string,
	category: {
		name: string,
		image: string
	},
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

Categories {
	_id: ObjectId,
	name: string,
	image: string
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
	articles: [Articles],
	owner: Users._id

}

Users {
	_id: ObjectId,
	firstname: string,
	lastname: string,
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