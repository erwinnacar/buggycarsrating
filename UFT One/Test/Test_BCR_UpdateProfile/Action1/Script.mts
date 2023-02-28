'#########################################################################################################################
'## TEST NAME: Test_BCR_UpdateProfile
'## DESCRIPTION: Update an existing user profile
'#########################################################################################################################
'## DOCUMENT HISTORY:   AUTHOR                     	DATE                	DESCRIPTION    
'##						  Erwin Nacar		26/02/2023			Initial
'#########################################################################################################################

'Launch chrome and application URL
Proc_OpenBrowser Environment("Url")

'Login as an existing user
Proc_BCR_Login

'Update Profile
Proc_BCR_UpdateProfile

'Logout from the application
Proc_BCR_Logout

'Close the Application
Proc_CloseBrowser
