    @AddEvent
    Feature: Users can add event for vehicle types


    Background: Users can see vehicles table
      Given users navigate to "Fleet" and then "Vehicles"
      Given users can see "vehicles" page

      @Driver @FLT-1270
      Scenario: Drivers can't see AddEvent button
        When users click on any vehicle
        And users will see specific car page
        Then Drivers can't see addEvent button

      @SalesManager @FLT-1260 @FLT-1261
      Scenario: Sales Managers can see AddEvent button
        When users click on any vehicle
        And users will see specific car page
        Then Users can see addEvent button
        And Users can click on addEvent button

      @StoreManager @FLT-1265 @FLT-1266
      Scenario: Store Managers can see AddEvent button
        When users click on any vehicle
        And users will see specific car page
        Then Users can see addEvent button
        And Users can click on addEvent button

      @SalesManager @FLT-1262 @AddEventClose
      Scenario: Sales Managers can see AddEvent page
        When users click on any vehicle
        And users will see specific car page
        And Users clicked on addEvent button
        Then AddEvent Page opens

        @SalesManager @AddEventClose @FLT-1263
        Scenario: Compulsory Fields must be marked
          When users click on any vehicle
          And users will see specific car page
          And Users clicked on addEvent button
          Then Compulsory Fields must be shown
          |Title|
          |Owner|
          |Organizer display name|
          |Organizer email      |
          |Start Date           |
          |End Date             |

      @FLT-1264 @FLT-1257 @SalesManager @AddEventClose
      Scenario Outline: Verify that Sales Managers can't create event without filling out compulsory fields
        When users click on any vehicle
        And users will see specific car page
        And Users clicked on addEvent button
        Then Users shouldnt save event by only filling out "<Input>"
        Examples:
          |Input|
          |title|
          |organizerEmail|
          |organizerDisplay|

          @StoreManager @AddEventClose @FLT-1267
          Scenario: Store Managers can see AddEvent page
            When users click on any vehicle
            And users will see specific car page
            And Users clicked on addEvent button
            Then AddEvent Page opens

          @StoreManager @AddEventClose @FLT-1268
          Scenario: Compulsory Fields must be marked
            When users click on any vehicle
            And users will see specific car page
            And Users clicked on addEvent button
            Then Compulsory Fields must be shown
              |Title|
              |Owner|
              |Organizer display name|
              |Organizer email      |
              |Start Date           |
              |End Date             |

          @StoreManager @AddEventClose @FLT-1269
          Scenario Outline: Compulsory Fields must be filled out
            When users click on any vehicle
            And users will see specific car page
            And Users clicked on addEvent button
            Then Users shouldnt save event by only filling out "<Input>"
            Examples:
            |Input|
            |title|
            |organizerEmail|
            |organizerDisplay|








