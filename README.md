# Mong-eat

...

## Getting started

...

## API

...

## MongoDB

### Getting Started

Make your way to the `./Documentation/Database/Stub` folder and type:

```bash
mongosh --file install.js
```

> We assume that you already have installed the mongosh bash and add it's path to your OS "global path".

This script contains the defaut database path, please edit it if your configuration is different.

```js
db = connect('mongodb://localhost:27017/MongEat')
```

### Collections

> Find the database collections description [here](./Documentation/Database/Collections.md).

### CDM

> Find a simple CDM [here](./Documentation/Database/CDM.md). 
> It doesn't fill well with mongo but that can help to understand the objects interractions.

## Credits

* Co-author [Mathis Ribémont](https://github.com/TEDDAC)
* Co-author [Valentin Clergue](https://github.com/HandyS11)