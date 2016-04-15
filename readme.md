# TRANSACTOLATOR CONSUMER

1. In the Heroku environment variable configuration panel (https://dashboard.heroku.com/apps/$YOURAPP/settings) set `DATOMIC_EMAIL` and `DATOMIC_KEY` to your credentials as provided by Cognitect at https://my.datomic.com/account. Then, set the `BUILD_CONFIG_WHITELIST` environment variable to the string "`DATOMIC_EMAIL DATOMIC_KEY`" to whitelist those environment variables into the Heroku build pipeline.

2. Push to Heroku.

3. Run:

   `heroku addons:create transactolator && heroku addons:open transactolator`

    The second command above will open a browser window that asks for your Transactor license key. Get it in there!

4. Sit back, relax, wait for Bezos to marshall infrastructure, and your Transactor will pop up shortly.

# Alpha Notice

Sign up for Transactolator alpha access at http://tx.survantjames.com. Once approved, you'll be able to provision a Transactor through the Heroku Addons flow.
