https://www.journaldev.com/1997/servlet-jdbc-database-connection-example

CREATE TABLE Book (
   id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   title VARCHAR(255),
   price INT NOT NULL,
   amount INT NOT NULL,
   ts timestamp default current_timestamp,
   PRIMARY KEY (Id)
);

<script type="text/javascript">
    function get_action(form) {
        form.action = form_action;
    }
</script>

<form onsubmit="get_action(this);">
    ...
</form>
