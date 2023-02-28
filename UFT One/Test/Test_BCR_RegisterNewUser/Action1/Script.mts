'#########################################################################################################################
'## TEST NAME: Test_BCR_RegisterNewUser
'## DESCRIPTION: Register a new user
'#########################################################################################################################
'## DOCUMENT HISTORY:   AUTHOR                     	DATE                	DESCRIPTION    
'##						  Erwin Nacar		26/02/2023			Initial
'#########################################################################################################################

'Launch chrome and application URL
Proc_OpenBrowser Environment("Url")

'Register new User
Proc_BCR_RegisterNewUser

'Close the Application
Proc_CloseBrowser
