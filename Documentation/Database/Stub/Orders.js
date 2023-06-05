export const OrdersStub = [
  {
    _id: ObjectId("64799a8ec40b7a7aad35ac40"),
	status: "Done",
	price: 13.99,
    tip: 0,
	reduction: 0,
	fee: 1.5,
	articles: [
        ObjectId("64705dda1fe1d56fab1b17b2")
    ],
	owner: ObjectId("647063c7e4314fe5feca99f2"),
    "location": [
        {
            "point": {
                "x": -4.443184,
                "y": 57.306340
            },
            "address": {
                "country": "United-Kingdom",
                "city": "Loch Ness",
                "road": "Inverness IV63 7YD"
            }
        }
    ]
  }
]