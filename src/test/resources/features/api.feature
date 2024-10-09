Feature: Test REST API Automation

  @api
  Scenario: Test get list data with a valid URL
    Given prepare a valid URL for "GET_LIST_USERS"
    And hit the API to get list data
    Then the status code should be 200
    Then the response message should be "OK"
    Then validation response body get list users
    Then validation response JSON with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test get list data with an invalid URL
    Given prepare an invalid URL for the "GET_LIST_USERS"
    And hit the API to get list data
    Then the status code should be 404
    Then the response message should be "Not Found"

  @api
  Scenario: Test get list data with a valid URL without authorization
    Given prepare a valid URL without a valid token for the "GET_LIST_USERS"
    And hit the API to get data
    Then the status code should be 401
    Then the response message should be "Unauthorized"
    Then validation response JSON with JSONSchema "get_list_users_without_authorization.json"

  @api
  Scenario: Test create new users normal
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "post_create_new_users_normal.json"

  @api
  Scenario: Test create new users without authorization
    Given prepare a valid URL without a valid token for the "CREATE_NEW_USERS"
    And hit the API to post create new users
    Then the status code should be 401
    Then the response message should be "Unauthorized"
    Then validation response JSON with JSONSchema "post_create_new_users_without_authentication.json"

  @api
  Scenario: Test create new users with a taken email
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API to create new users
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "post_create_new_users_taken_email.json"

  @api
  Scenario: Test create new users with incomplete fields in the body
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users without body
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "post_create_new_users_incomplete_body.json"

  @api
  Scenario: Test delete users normal
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    And hit the API delete users
    Then the status code should be 204
    Then the response message should be "No Content"

  @api
  Scenario: Test delete users with non-existent user ID
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    And hit the API to delete users
    Then the status code should be 404
    Then the response message should be "Not Found"
    Then validation response JSON with JSONSchema "delete_users_nonexistent_id.json"

  @api
  Scenario: Test update users normal
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    And hit the API to update data
    Then the status code should be 200
    Then the response message should be "OK"
    Then validation response body update users
    Then validation response JSON with JSONSchema "update_users_normal.json"

  @api
  Scenario: Test update users with empty field
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    And hit the API to update data with empty field
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "update_users_empty_field.json"

  @api
  Scenario: Test update users with a non-existing user ID
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    And hit the API to update data with non-existing ID
    Then the status code should be 404
    Then the response message should be "Not Found"
    Then validation response JSON with JSONSchema "update_users_nonexisting_id.json"

# Boundary Tests

  @api
  Scenario: Test name field boundary with minimum value length
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with only one character name
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "name_field_boundary_normal.json"

  @api
  Scenario: Test name field boundary with maximum value length
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with 200 characters
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "name_field_boundary_normal.json"

  @api
  Scenario: Test name field boundary beyond maximum value length
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with more than 200 characters
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "name_field_beyond_maximum.json"

  @api
  Scenario: Test email field boundary with minimum value length
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with only one character email
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "email_field_boundary_normal.json"

  @api
  Scenario: Test email field boundary with maximum value lengths
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with 200 characters email
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "email_field_boundary_normal.json"

  @api
  Scenario: Test email field boundary beyond maximum value lengths
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with more than 200 characters email
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "email_field_beyond_maximum.json"

  @api
  Scenario: Test email field boundary with invalid value
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create users with invalid email format
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "email_field_invalid_value.json"

  @api
  Scenario: Test gender field boundary with valid value
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users with valid gender field
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "gender_field_boundary_normal.json"

  @api
  Scenario: Test gender field boundary with invalid value
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users with invalid gender
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "gender_field_invalid_value.json"

  @api
  Scenario: Test status field boundary with valid value
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users with valid status
    Then the status code should be 201
    Then the response message should be "Created"
    Then validation response body post create new users
    Then validation response JSON with JSONSchema "status_field_boundary_normal.json"

  @api
  Scenario: Test status field boundary with invalid value
    Given prepare a valid URL for "CREATE_NEW_USERS"
    And hit the API post create new users with invalid status
    Then the status code should be 422
    Then the response message should be "Unprocessable Entity"
    Then validation response JSON with JSONSchema "status_field_invalid_value.json"
