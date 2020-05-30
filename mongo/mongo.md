# Mongo


MongoDB is in many ways like a power drill. Your ability to complete a task is framed largely by the components you choose to use (from drill bits of varying size to sander adapters). MongoDB’s strength lies in versatility, power, ease of use, and ability to handle jobs both large and small. Although it’s a much newer invention than the hammer, it is increasingly a tool builders reach for quite often.

## `Create` a new database
To create a new database named book, first run this command in your terminal. It will connect to the MySQL-inspired command-line interface.
```
mongo book
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimg.cc/3dmdd110' target='_blank'>
<img src='https://i.postimg.cc/PrFZVF8y/image.png' border='0' alt='image'>
</img>
</a>
</p>
</details>

## `Show` and `Use` database
We’re currently in the book database, but you can view others via `show dbs` and switch databases with the `use` command.
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/66nTvrRH/image.png' border='0' alt='image'/></a>
</img>
</a>
</p>
</details>

## `Insert` a new row

 Since Mongo is schema- less, there is no need to define anything up front; merely using it is enough. What’s more, our book database doesn’t really exist until we first add values into it. The following code creates/inserts a towns collection:
```
db.towns.insert({
name: "New York",
population: 22200000,
last_census: ISODate("2009-07-31"), famous_for: [ "statue of liberty", "food" ], mayor : {
name : "Michael Bloomberg",
party : "I" }
})
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimg.cc/Xp85x3Gk' target='_blank'><img src='https://i.postimg.cc/cLqcxLd2/image.png' border='0' alt='image'/></a>
</img><p>Robo3T</p>
<a href='https://postimg.cc/pm3NpmQ0' target='_blank'><img src='https://i.postimg.cc/KY8mpL1y/image.png' border='0' alt='image'/></a>
</a>
</p>
</details>

## `Show collections` available in a dbs
With the `show collections` command, you can verify the collection now exists.
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/j5086wvH/image.png' border='0' alt='image'/></a>
</p>
</details>

## We can list the contents of a collection via `find()`

` db.towns.find()`

<details><summary>Screenshot</summary>
<p>
<a href='https://postimg.cc/WDmj4B8h' target='_blank'><img src='https://i.postimg.cc/QMwMfsWk/image.png' border='0' alt='image'/></a>
<p>Robo3T</p>
<a href='https://postimg.cc/pm3NpmQ0' target='_blank'><img src='https://i.postimg.cc/KY8mpL1y/image.png' border='0' alt='image'/></a>
</a>
</p>
</details>
<br>

Mongo does not support `server-side joins`.

You may have noticed that the JSON output of your newly inserted town contains an `_id` field of `ObjectId`. This is akin to SERIAL incrementing a numeric primary key in PostgreSQL. The `ObjectId` is always `12 bytes`, composed of a `timestamp`, `client machine ID`, `client process ID`, and a 3`-byte incremented counter`.

<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/cJSczyyY/image.png' border='0' alt='image'/></a>
</p>
</details>


## JavaScript
Mongo’s native tongue is __JavaScript__, be it as complex as mapreduce queries or as simple as asking for `help`.
```
db.help()
db.towns.help()
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimg.cc/q6JZGY2D' target='_blank'><img src='https://i.postimg.cc/MHV2zJHw/image.png' border='0' alt='image'/></a>
<br><br>
<a href='https://postimg.cc/jnDyK4Td' target='_blank'><img src='https://i.postimg.cc/rsJj1fYW/image.png' border='0' alt='image'/></a>
</p>
</details>

## Source code of a function
If you want to inspect the source code for a function, call it without parameters or parentheses (think more Python than Ruby).
`db.towns.insert`

<details><summary>Screenshot</summary>
<p>
<a href='https://postimg.cc/dk3Y94rB' target='_blank'><img src='https://i.postimg.cc/qRXv4F79/image.png' border='0' alt='image'/></a>

</p>
</details>

## Creating out own function
Let’s populate a few more documents into our towns collection by creating our own JavaScript function.

```
function insertCity(
name, population, last_census, famous_for, mayor_info
){ db.towns.insert({
    name:name,
    population:population,
    last_census: ISODate(last_census),
    famous_for:famous_for,
    mayor : mayor_info
}); }

insertCity("Punxsutawney", 6200, '2008-31-01', ["phil the groundhog"], { name : "Jim Wehrle" }
)

insertCity("Portland", 582000, '2007-20-09',
["beer", "food"], { name : "Sam Adams", party : "D" }
)

db.towns.find()
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/nrmbnjTM/image.png' border='0' alt='image'/></a>
<br><br>
<a href='https://postimg.cc/bSv9r2Xd' target='_blank'><img src='https://i.postimg.cc/cCR9DQX7/image.png' border='0' alt='image'/></a>
</p>
</details>

## Reading: More Fun in Mongo
🤣 chacha enjoy 🤣

### Find function with params
Earlier we called the find() function without params to get all documents. To access a specific one, you only need to set an _id property. _id is of type ObjectId, and so to query, you must convert a string by wrapping it in an ObjectId(str) function.

Here the `ObjectId` will differ. (Do not copy paste ✂️📋)
```
db.getCollection('towns').find({_id : ObjectId("5ed210447194944511fb2cf9")})
```

<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/FzxjwGcZ/image.png' border='0' alt='image'/></a>
</p>
</details>

### Filter the fields to retrieve
The `find()` function also accepts an optional second parameter: a fields object we can use to filter which fields are retrieved.

If we want only the town `name` (along with `_id`), pass in `name` with a value resolving to `1 (or true)`.
```
db.getCollection('towns').find({_id : ObjectId("5ed210447194944511fb2cf9")},{name : 0})

db.getCollection('towns').find({_id : ObjectId("5ed210447194944511fb2cf9")},{name : 1})

db.getCollection('towns').find({_id : ObjectId("5ed210447194944511fb2cf9")},{name : 1, population : 1, _id : 0})
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/3RNXz295/image.png' border='0' alt='image'/></a>
<br><br>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/MGWbbCQG/image.png' border='0' alt='image'/></a>
<br><br>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/XY6gXGNd/image.png' border='0' alt='image'/></a>
</p>
</details>


### Regex and combination of criteria
Like PostgreSQL, in Mongo you can construct ad hoc queries by field values, ranges, or a combination of criteria.

To find all towns that begin with the letter P and have a population less than 10,000, you can use a Perl-compatible regular expression (PCRE)2 and a range operator.

```
db.towns.find(
  { name : /^P/, population : { $lt : 10000 } },
  { name : 1, population : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/SRsm6xyG/image.png' border='0' alt='image'/></a>
</p>
</details>

### Power of JavaScript
Conditional operators in Mongo follow the format of field : { $op : value }, where $op is an operation like $ne (not equal to). You may want a terser syntax, like field < value. But this is JavaScript code, not a domain-specific query language, so queries must comply with JavaScript syntax rules

Here, we build criteria where the population must be between 10,000 and 1 million people.

```
var population_range = {}
population_range['$lt'] = 1000000
population_range['$gt'] = 10000

db.towns.find(
    { name : /^P/, population : population_range },
    { name: 1 }
)

db.towns.find(
    { last_census : { $lte : ISODate('2008-31-01') } },
    { _id : 0, name: 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/SxjVBFKt/image.png' border='0' alt='image'/></a>
<br><br>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/0jT29qsd/image.png' border='0' alt='image'/></a>
</p>
</details>

### Digging Deep
#### Mongo `loves` nested array data. You can query by matching exact values

```
db.towns.find(
    { famous_for : 'food' },
    { _id : 0, name : 1, famous_for : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/MZmSTRYJ/image.png' border='0' alt='image'/></a>
<br><br>
</p>
</details>


#### See the power of partial matching `/`

```
db.towns.find(
    { famous_for : /statue/ },
    { _id : 0, name : 1, famous_for : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/k5vc8nYG/image.png' border='0' alt='image'/></a>
</p>
</details>

#### Query by `all` matching values

```
db.towns.find(
    { famous_for : { $all : ['food', 'beer'] } },
    { _id : 0, name:1, famous_for:1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/HxffxwSX/image.png' border='0' alt='image'/></a>
</p>
</details>

#### The lack of matching values

```
db.towns.find(
    { famous_for : { $nin : ['food', 'beer'] } },
    { _id : 0, name : 1, famous_for : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/13BXqX1f/image.png' border='0' alt='image'/></a>
</p>
</details>

### Query subdocument
##### To query a subdocument, your field name is a string separating nested layers with a dot.

```
db.towns.find(
    { 'mayor.party' : 'I' },
    { _id : 0, name : 1, mayor : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/L67NM9bg/image.png' border='0' alt='image'/></a>
</p>
</details>

##### Those with mayors who don’t have a party:


```
db.towns.find(
    { 'mayor.party' : { $exists : false } },
    { _id : 0, name : 1, mayor : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/Y28tRVys/image.png' border='0' alt='image'/></a>
</p>
</details>

### elemMatch

We’ll round out our dig with the `elemMatch` directive. Let’s create another collection that stores countries. This time we’ll override each `_id` to be a string of our choosing.
```
db.countries.insert({ _id : "us", name : "United States", exports : { foods : [ { name : "bacon", tasty : true }, { name : "burgers" } ] } })
db.countries.insert({ _id : "ca", name : "Canada", exports : {foods : [{ name : "bacon", tasty : false }, { name : "syrup", tasty : true } ] } })
db.countries.insert({ _id : "mx", name : "Mexico", exports : { foods : [{ name : "salsa", tasty : true, condiment : true }] } })
```

Let’s find a country that not only exports bacon but exports tasty bacon.
```
db.countries.find(
    { 'exports.foods.name' : 'bacon', 'exports.foods.tasty' : true },
    { _id : 0, name : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/zG2sRYvn/image.png' border='0' alt='image'/></a>
</p>
</details>
<br>

But this isn’t what we wanted. Mongo returned Canada because it exports bacon and exports tasty syrup. $elemMatch helps us here. It specifies that if a document (or nested document) matches all of our criteria, the document counts as a match.
```
db.countries.find(
    {
    'exports.foods' : {
        $elemMatch : {
            name : 'bacon',
            tasty : true
            }
        }
    },
    { _id : 0, name : 1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/c4ShT92P/image.png' border='0' alt='image'/></a>
</p>
</details>

### Boolean Ops
So far, all of our criteria are implicitly and operations. If you try to find a country with the name United States and an _id of mx, Mongo will yield no results.

```
db.countries.find(
    { $or :
        [
            { _id : "mx" },
            { name : "United States" }
        ]
    },
    { _id:1 }
)
```
<details><summary>Screenshot</summary>
<p>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/QtnLcLfL/image.png' border='0' alt='image'/></a>
</p>
</details>
<br>
<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/htSBF0z5/image.png' border='0' alt='image'/></a>

###

```

```
<details><summary>Screenshot</summary>
<p>

</p>
</details>
