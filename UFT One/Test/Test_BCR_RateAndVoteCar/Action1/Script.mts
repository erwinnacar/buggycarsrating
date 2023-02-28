'#########################################################################################################################
'## TEST NAME: Test_BCR_RateAndVoteCar
'## DESCRIPTION: Rate and cast a vote for a car by popular make
'#########################################################################################################################
'## DOCUMENT HISTORY:   AUTHOR                     	DATE                	DESCRIPTION    
'##						  Erwin Nacar		27/02/2023			Initial
'#########################################################################################################################

'Launch chrome and application URL
Proc_OpenBrowser Environment("Url")

'Login as an existing user
Proc_BCR_Login

'Rate and vote car
Proc_BCR_RateCarByPopularMake

'Logout from the application
Proc_BCR_Logout

'Close the Application
Proc_CloseBrowser


