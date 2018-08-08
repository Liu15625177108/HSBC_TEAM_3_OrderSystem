/user/register/send-verify-message:
	post:
	description:
	queryParameters:
		example: |
			{
				"phone-number":"15521301710"
			}
	body:
		application/json:
	response:
		200:


/user/register/phone-verify
	post:
	description:
	queryParameters:
		"verifyCode":"012345"
	response：
		200：
			body:
				application/json:
				example: |
					{
						"verify": true;
					}
		500:
			body:
				application/json:
				example: |
					{
						"verify": false;
					}
					
user/register/username-check
	get:
	description:
	queryParameters:
		example: |
			{
				"username":"15521301710"
			}
	response:
		200:
			body:
			application/json:
				example: |
					{
						"available": true;
					}
		500:
			body:
			application/json:
				example: |
					{
						"available": false;
					}
					
user/register/login-message:
	post:
	body:
		application/json:
			example: |
				{
					"username":"15521301710"
					"password":"15521301710"
					"Security-question":{
						"question1":"answer1",
						"question2":"answer2",
						"question3":"answer3"
					}
				}
	response:
		200:
			body:
				application/json:
					example: |
						{
							"login-message- verify":true
						}
	

				
				
				
				
				
				
				
				
				
				
				