
## Design details

<ul>
<li>The domain classes are Immutable including their fields like List</li>
<li>Brought loose coupling by applying <b>Principle of least Knowledge.</b> For Eg:</b>
<li>The controller module interacts with other modules like validation, fileProcessor by only one 
    interface. validation and fileProcessor modules are <b>Encapsulated</b> with thier specific responsibilities.</li>
<li>Used least scope where possible to hide internals of a modules. For eg,  classes like BalanceValidation.Java have default scope, this means they can be seen only in their package. The hiding of module internals rule can even be further enforced with <b>Java 9 Module System</b>.</li>
<li><b>Encapsulate what varies principle.</b> I see the specific validations like balance check and reference uniqueness are varying parts of the system, hence they are separated from normally unchanging framework.</li>
 <li>The domain classes have string values instead of specific type. Because, I wanted to consider non-number values also and inform user about discrepancy at every record level. Types like BigDecimal/BigInteger can be used in domain itself if the user doesn’t want to see fine grained data type error messages.</li>           
<li>Used Functional programming</li>
</ul>

## Steps to run application
<ul>
<li>mvn install : to build the code</li>
<li>mvn spring-boot:run : to run the application</li>
<li>The API can be reached at http://localhost:8080/customer-statement</li>
<li>Upload the CSV file as 'file' attribute in POST body </li>
</ul>

## Version info
<ul>
<li>Java 8(atleast 131 minor update)</li>
<li>Maven 3.5.0</li>
</ul>
