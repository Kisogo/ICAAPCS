import sqlite3
import random
import sys

# Create a Connection object in RAM that represents the database.
conn = sqlite3.connect(":memory:")


# Create a Cursor object from the Connection object.
#   Call the Cursor's execute() method to run commands.
c = conn.cursor()


# Using the Cursor, execute a CREATE TABLE command to create table named stocks.
c.execute(''' CREATE TABLE stocks
                (date text, trans text, symbol text, qty real, price real)''')
                
                # Note SQLite's types:
                    # null : A Null value.
                    # integer : A signed integer.
                    # text : A text string, stored using the DB encoding (UTF-8, UTF-16BE or UTF-16LE)
                    # real : A floating point value.
                    # blob : A blob of data, stored exactly as it was input.
                    
# Insert one row of data.
c.execute("INSERT INTO stocks VALUES ('2006-01-05', 'BUY', 'RHAT', 100, 23.21)")

# Insert many rows at once.
purchases = [('2006-03-28', 'BUY', 'IBM', 1000, 45.00),
             ('2006-04-05', 'BUY', 'MSFT', 1000, 72.00),
             ('2006-04-06', 'SELL', 'IBM', 500, 53.00),
            ]
c.executemany('INSERT INTO stocks VALUES (?, ?, ?, ?, ?)', purchases)


# Insert many rows of data.
#prices = ()
#for i in range(100):
#    prices = prices + ((random.uniform(1,10)+100,),)

#c.executemany("INSERT INTO stocks VALUES ('2006-01-05', 'BUY', 'RHAT', 100, ?)", prices)


# Display a row of data (Insecurely) -- NEVER DO THIS!
#symbol = 'RHAT'
#c.execute("SELECT * FROM stocks WHERE symbol = '%s'" %symbol)


# Display a row of data (Securely).
#t = ('RHAT',)
#c.execute('SELECT * FROM stocks WHERE symbol=?', t)

#t = ('BUY',)
#c.execute('SELECT * FROM stocks WHERE trans=?', t)


# Display any row of data that match REGEX
    # '%' is wildcard character
c.execute('SELECT * FROM stocks WHERE date LIKE "%%%%-04-%%"')

# Fetch one row.
#print(c.fetchone())


# Fetch all rows that meet the cursor's query.
print(c.fetchall())


# Save (commit) the changes through the Connection object.
conn.commit()


# Close the connection. Any uncommitted changes will be lost!
conn.close()
                   