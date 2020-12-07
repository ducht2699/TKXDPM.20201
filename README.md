# LAB 00 - Create SRS document for EcoBikeRental
## Tasks
  - Task 01: Create Use case diagram 
  - Task 02: Create use case Specification "View Bike in Station"
  - Task 03: Create use case Specification "View Bike Information"
  - Task 04: Create use case Specification "Rent Bike" 
  - Task 05: Create use case Specification "Return Bike" 
  - Task 06: Create use case separation
  - Task 07: Create business process (Activity diagram) 
  - Task 08: Merge to SRS document
## Contributions
  - Task 01: Nguyễn Thành Long
  - Task 02: Nguyễn Hải Long
  - Task 03: Nguyễn Công Luật
  - Task 04: Nguyễn Thành Long
  - Task 05: UL LyAn
  - Task 06: Nguyễn Công Luật
  - Task 07: Nguyễn Hải Long
  - Task 08: UL LyAn
## Revisions
  - Task 01: Nguyễn Hải Long (Reviewer)
  - Task 02: Nguyễn Thành Long (Reviewer)
  - Task 03: UL LyAn (Reviewer)
  - Task 04: Nguyễn Công Luật (Reviewer)
  - Task 05: Nguyễn Công Luật (Reviewer)
  - Task 06: Nguyễn Thành Long (Reviewer)
  - Task 07: UL LyAn (Reviewer)
  - Task 08: Nguyễn Hải Long (Reviewer)

# LAB 01 - Create Interaction Diagram (Communication Diagram and/or Sequence Diagram)
## Tasks
  - Task 01: Create Interaction Diagram "View Bike in Station"
  - Task 02: Create Interaction Diagram "View Bike Information"
  - Task 03: Create Interaction Diagram "Rent Bike" 
  - Task 04: Create Interaction Diagram "Return Bike" 
## Contributions
  - Task 01: Nguyễn Hải Long
  - Task 02: guyễn Công Luật
  - Task 03: Nguyễn Thành Long
  - Task 04: UL LyAn
## Revisions
  - Task 01: Nguyễn Công Luật (Reviewer)
      1.  file: Sequence-Diagram-ViewBikeinStation.asta
      -   Lack of searching station before view station information
      -   Lack of request view list bike of station before view bike information
  - Task 02: Nguyễn Thành Long (Reviewer)
      1.  file: Sequence Diagram View Bike Information.asta
      -   Name Payment controller need to change to Payment Transaction to synchronize
      -   Payment Transaction just save time start rent and View Bike Controller have to calculate time current and time start rent.
  - Task 03: UL LyAn (Reviewer)
      1.  file: Sequence Diagram Rent Bike.asta
      -   Scan barcode have to notify fail or success message
      -   saveTransaction have to place before display success. in case  having error saving.
  - Task 04: Nguyễn Hải Long (Reviewer)
      1.  file: Sequence Diagram  Return Bike.asta
      -   scan barcode have to notify fail or success
      -   DockingPoint Entity is unnecessary.
      -   requestPayment to display real price and deposit return before confirm payment.
      -   lock bike and saveTransaction should be separate out

# LAB 02 - Create Class Analysis Diagram, Complete Architecture Analysis
## Tasks
  - Task 01: Create Class Analysis Diagram "View Bike in Station"
  - Task 02: Create Class Analysis Diagram "View Bike Information"
  - Task 03: Create Class Analysis Diagram "Rent Bike" 
  - Task 04: Create Class Analysis Diagram "Return Bike" 
  - Task 05: Merge Class Analysis Diagrams to System Class Analysis Diagram
## Contributions
  - Task 01: Nguyễn Hải Long
  - Task 02: Nguyễn Công Luật
  - Task 03: Nguyễn Thành Long
  - Task 04: UL LyAn
  - Task 05: Nguyễn Thành Long
## Revisions
  - Task 01: Nguyễn Công Luật (Reviewer)
  - Task 02: Nguyễn Thành Long (Reviewer)
  - Task 03: UL LyAn (Reviewer)
  - Task 04: Nguyễn Hải Long (Reviewer)
  - Task 05: UL LyAn (Reviewer)

# LAB 03 - Design Interface
## Tasks
  - Task 04: Design and create transition display diagram, specification for view bike information display
  - Task 05: Design and create transition display diagram, specification for view station information display
  - Task 06: Design and create transition display diagram, specification for rent bike display
  - Task 08: Design and create transition display diagram, specification for return bike display

## Contributions
  - Task 01: Nguyễn Công Luật
  - Task 02: Nguyễn Hải Long
  - Task 03: Nguyễn Thành Long
  - Task 04: UL LyAn

## Revisions
  - Task 01: UL LyAn (Reviewer)
  - Task 02: Nguyễn Thành Long (Reviewer)
  - Task 03: Nguyễn Công Luật (Reviewer)
  - Task 04: Nguyễn Hải Long (Reviewer)
  
# LAB 04 - Design Class
## Tasks
  - Task 01: Design class for view bike information display
  - Task 02: Design class for view station information display
  - Task 03: Design class for rent bike display
  - Task 04: Design class for return bike display

## Contributions
  - Task 01: Nguyễn Công Luật
  - Task 02: Nguyễn Hải Long
  - Task 03: Nguyễn Thành Long
  - Task 04: UL LyAn

## Revisions
  - Task 01: UL LyAn (Reviewer)
  - Task 02: Nguyễn Thành Long (Reviewer)
  - Task 03: Nguyễn Công Luật (Reviewer)
  - Task 04: Nguyễn Hải Long (Reviewer)
 
# LAB 05 - Design Database, Complete Detail Design
## Tasks
  - Task 01: Design E-R Diagram
  - Task 02: Design Database 
  - Task 03: Design detail table/document
  - Task 04: Complete SDD(software design document)

## Contributions
  - Task 01: UL LyAn
  - Task 02: Nguyễn Thành Long
  - Task 03: Nguyễn Hải Long
  - Task 04: Nguyễn Công Luật

## Revisions
  - Task 01: Nguyễn Công Luật (Reviewer)
  - Task 02: Nguyễn Hải Long (Reviewer)
  - Task 03: Nguyễn Thành Long (Reviewer)
  - Task 04: UL LyAn (Reviewer)
  
# LAB 06 - Unit Test
## Tasks
  - Task 01: Create unit test for usecase rent bike
  - Task 02: Create unit test for usecase return bike
  - Task 03: Create unit test for usecase view station information
  - Task 04: Create unit test for usecase view bike information

## Contributions
  - Task 01: Nguyễn Thành Long
  - Task 02: UL LyAn
  - Task 03: Nguyễn Hải Long
  - Task 04: Nguyễn Công Luật

## Revisions
  - Task 01: Nguyễn Công Luật (Reviewer)
  - Task 02: Nguyễn Hải Long (Reviewer)
  - Task 03: Nguyễn Thành Long (Reviewer)
  - Task 04: UL LyAn (Reviewer)
  
# LAB 07 - Programming
## Tasks
  - Task 01: Write code for usecase rent bike
  - Task 02: Write code for usecase return bike
  - Task 03: Write code for usecase view station information
  - Task 04: Write code for usecase view bike information

## Contributions
  - Task 01: Nguyễn Thành Long
  - Task 02: UL LyAn
  - Task 03: Nguyễn Hải Long
  - Task 04: Nguyễn Công Luật

## Revisions
  - Task 01: Nguyễn Công Luật (Reviewer)
    1.  file: PaymentScreen.java
      -  need separate controller and view in file Boundary PaymentScreen.java
  - Task 02: Nguyễn Hải Long (Reviewer)
    1.  file: ReturnBike.java
      -  have to pass transaction to Return route to get info to payment.
  - Task 03: Nguyễn Thành Long (Reviewer)
    1.  file: FindStationScreen.form, ViewListBikeScreen.form
      -  table need resize to smaller, avoid full screen.
    2.  file: StationInfoScreen.java
      -  Image station need to change, but it was QR code.
  - Task 04: UL LyAn (Reviewer)
    1.  file: RentingBike.form
      -  resize renting screen to fixed size( 700x400 )
      -  table content is not allow editable and resizable
      
