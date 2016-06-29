# test-config-server-crypto
test for https://github.com/spring-cloud/spring-cloud-config/issues/434


```
git clone https://github.com/bitsofinfo/test-config-server-crypto.git
cd test-config-server-crypto
cd configserver_gitrepo/
git init
git add .
git commit -m "test" .
cd ..
```

EDIT src/main/resources/bootstrap.yml and adjust the `spring.cloud.config.server.git.uri` repo path as appropriate to the one above

```
./gradlew bootRun
```

Notice at the end of the boot, it prints out the values for the two properties in the environment `application.yml` (this print occurs in Application.java

Notice that `test.crypted.prop` at this point is **not decrypted**.... (not sure why? its not cleartext at this point as I need the decrypted value to configure another bean while the boot is in progress)

After boot up, go to: http://localhost:8888/config-server-test1/test  (decrypted as expected)

POST the below to http://localhost:8888/decrypt

```
{key:alias1}AQA5xheTRLF2E7vgHnLy3Ef9fa2tQn7FSI70/XbKmSksVdSmY1OmefCytplTiTFJvJN0wkHoLQLE8IBRi9MEvTy1iATssoO43XCkjLXx2ur5Cvk7ItOUhST9eHBqDqam8uox8y6vHjk4hIczhS6RhYV+tIVgabeFgAekPUILrP3bMmTJ1PZz+69vbK9B2ZTx/XQAwt8n4ZStGkoZ8ZofQFtv8erZDc3ZEzkpzyggwrqSw2wi1tPD8J96NUxWmtx3YWCElgwqDXWgfULnFzDAPejZ9z6WrWBgIo177knOeukqI2/uGUlgMqDKkI6FgTwE8kodqoNT3uyutz1hy2Hygi0LeU8y6jkqa6YPz3kagcrKDzBLYWQ+YlAoHXehDGe0L5g=
```

You yield 123 as expected.





