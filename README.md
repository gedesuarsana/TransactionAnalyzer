# TransactionAnalyzer app
Simplified financial transaction analysis system.<br/>
 This app is used for display statistic information about processed financial transactions.

# Pre-requisites:
-Git installed on your local machine
<br/>
-IDE such as Intelij or Eclipse
<br/>
-Maven installed


# How to Build:
1. Go to your project directory open the command line
2. git clone https://github.com/gedesuarsana/TransactionAnalyzer.git
3. cd TransactionAnalyzer
4. mvn clean install


# How to Run:
1. On your project directory. 
2. cd target folder.
3. Run java -jar TransactionAnalyzer-1.0-SNAPSHOT.jar [CSV File Location] [From Date] [To Date] [Merchant Name]
4. For example: java -jar TransactionAnalyzer-1.0-SNAPSHOT.jar "C:\Users\gede\IdeaProjects\fake\TransactionAnalyzer\src\test\resources\InputData.csv" "20/08/2018 12:00:00" "20/08/2018 13:00:00" "Kwik-E-Mart"
5. The output will be displayed on the console like this:<br/>
Number of transactions = 1<br/>
Average Transaction Value = 59.99<br/>
   
 
 