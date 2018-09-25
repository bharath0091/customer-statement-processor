# customer-statement-processor

## Version info
<ul>
<li>Java 8(atleast 131 minor update)</li>
<li>Maven 3.5.0</li>
</ul>

##Design details
<ul>
<li>The domain classes are Immutable including their fields</li>
<li>Brought loose coupling bu applying <b>Principle of least Knoledge.</b> For Eg</b>
    <ul><li>The controller module interacts with other modules like validation, fileProcessor by only one 
    interface. validation and fileProcessor modules are <b>Encapsulated</b> with thier specific responsibilities</li>
    <li>Used least scope where possible to hide internals of a modules. For eg,  classes like BalanceValidation.Java have default scope, this means they can be seen only in their package.
    The hiding of module internals rule can even be further enforced with <b>Java 9 Module System</b></li>
    </ul>
</li>
<li>Used Functional programming</li>
</ul>

##Steps to run application
<ul>
<li>mvn install : to build the code</li>
<li>mvn spring-boot:run : to run the application</li>
<li>The API can be reached at http://localhost:8080/customer-statement</li>
<li>Upload the CSV file as 'file' attribute in POST body </li>
</ul>