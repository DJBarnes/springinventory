<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  <title>CAE Web</title>
  
  <link type="text/css" href="resources/css/layouts.css" rel="stylesheet" />
  <link rel="stylesheet" href="resources/css/tabs.css">
  <link rel="stylesheet" href="resources/css/inventory/inventory.css" type="text/css" media="screen">

  <!--Load jQuery dependency -->
  <script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>

  <!--Load Libs for applicaion -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"></script>
  <script src="resources/js/backbone.marionette.min.js"></script>
  <script src="resources/js/handlebars-v1.3.0.js"></script>

  <!--Initialize the Marionette app object -->
  <script src="resources/js/inventory/inventoryInit.js"></script>

  <!--Create modules in the app object that contain controllers -->
  <script src="resources/js/inventory/controllers/inventoryController.js"></script>
  <script src="resources/js/inventory/controllers/ordersController.js"></script>
  <script src="resources/js/inventory/controllers/placeOrdersController.js"></script>
  <script src="resources/js/inventory/controllers/viewLogController.js"></script>
  
    <!--Create backbone models inside modules -->
  <script src="resources/js/inventory/models/itemModel.js"></script>
  <script src="resources/js/inventory/models/orderModel.js"></script>
  <script src="resources/js/inventory/models/vendorModel.js"></script>
  <script src="resources/js/inventory/models/logModel.js"></script>

  <!--Create Initial Tab view for app -->
  <script src="resources/js/inventory/views/inventoryTabView.js"></script>

  <!--Create all the item views -->
  <script src="resources/js/inventory/views/InventoryViews/inventoryItemView.js"></script>
  <script src="resources/js/inventory/views/InventoryViews/inventoryCompositeView.js"></script>
  <script src="resources/js/inventory/views/InventoryViews/itemDetailsModalVendorListView.js"></script>
  <script src="resources/js/inventory/views/InventoryViews/itemDetailsModalView.js"></script>
  <script src="resources/js/inventory/views/InventoryViews/itemAddModalView.js"></script>

  <!--Create all of the accept order views -->
  <script src="resources/js/inventory/views/OrderViews/orderItemView.js"></script>
  <script src="resources/js/inventory/views/OrderViews/orderCompositeView.js"></script>
  <script src="resources/js/inventory/views/OrderViews/orderDetailsModalView.js"></script>

  <!--Create all of the place order views -->
  <script src="resources/js/inventory/views/PlaceOrderViews/placeOrderItemView.js"></script>
  <script src="resources/js/inventory/views/PlaceOrderViews/placeOrderCompositeView.js"></script>
  <!--<script src="../js/inventory/views/PlaceOrderViews/orderDetailsModalView.js"></script>-->

  <!--Create all of the view log views -->
  <script src="resources/js/inventory/views/LogViews/viewLogItemView.js"></script>
  <script src="resources/js/inventory/views/LogViews/viewLogCompositeView.js"></script>

  <!--Define util for templates, and main to kick the main application off -->
  <script src="resources/js/inventory/util.js"></script>
  <script src="resources/js/inventory/main.js"></script>
  
</head>

<body class="nosidebar">
  <div  id="fade">
  </div>
  <div id="header-wrapper">
    <div id="header">
      <div id="header-logo">
        <a title="CAE" href="<?php echo $url_home; ?>">
            <img src="resources/img/caeweb.png" alt="CAE" id="logo" height="55"/>
        </a>
      </div>
      <div id="header-greet">
        <p>Welcome, CAE User!</p>
      </div>
      <div id="header-menu">
        <ul id="jsddm">
          <li><a href="#">Home</a></li>
          <li><a href="#">Room Scheduling</a></li>
          <li><a href="#">Audio/Visual</a></li>
          <li><a href="#">Inventory</a></li>
          <li><a href="#">Employee</a></li>
          <li><a href="#">User Admin</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div id="content-wrapper">
    <div id="content">
      <div id="tabsDiv">
        <div id="innerTabsDiv">
          <ul class="tabs">
            <li id="currentinventory" class="currentinventory">Current Inventory</li>
            <li id="vieworders" class="vieworders selectedTab">View Orders</li>
            <li id="placeorder" class="placeorder">Place Order</li>
            <li id="viewlog" class="viewlog">View Log</li>
          </ul>
          <div id="tabsContent" class="tab-content">
            <div id="loadingDiv" class="loadingDiv">
              <div id="loadingCircleDiv">
                <img id='loadingCircle' src="resources/img/loading.gif" />
              </div>
            </div>
          </div>
          <div id="modalBox" class="div-modal-box">
          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="footer-wrapper">
    <div id="footer">
      <p><b>This is the footer.</b></p>
    </div>
  </div>
</body>
</html>
