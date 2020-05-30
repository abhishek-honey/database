# Mongo


MongoDB is in many ways like a power drill. Your ability to complete a task is framed largely by the components you choose to use (from drill bits of varying size to sander adapters). MongoDB’s strength lies in versatility, power, ease of use, and ability to handle jobs both large and small. Although it’s a much newer invention than the hammer, it is increasingly a tool builders reach for quite often.

* To create a new database named book, first run this command in your terminal. It will connect to the MySQL-inspired command-line interface.
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

* We’re currently in the book database, but you can view others via `show dbs` and switch databases with the `use` command.
* Since Mongo is schema- less, there is no need to define anything up front; merely using it is enough. What’s more, our book database doesn’t really exist until we first add values into it. The following code creates/inserts a towns collection:
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
