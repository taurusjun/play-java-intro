$ ->
  $.get "/persons", (data) ->
    $.each data, (index, person) ->
      $("#persons").append $("<li>").text person.name

$ ->
  $("#batchOp").on "click", (event)->
    postD={usrname: "AAAA"}
    $.ajax
      url: '/addPersonBatch'
      type: 'POST'
      dataType: 'json'
      contentType:'application/json;charset=UTF-8'
      data:JSON.stringify(postD)
      error: (jqXHR, textStatus, errorThrown) ->
        $('body').append "AJAX Error: #{textStatus}"
      success: (data, textStatus, jqXHR) ->
        $('#info').empty().append "BatchOp: Successful AJAX call: #{data.usrname}"

$ ->
  $("#batchOp2").on "click", (event)->
    postD={usrname: "AAAA"}
    $.ajax
      url: '/addPersonBatch2'
      type: 'POST'
      dataType: 'json'
      #contentType:'application/json;charset=UTF-8'
      data:postD
      error: (jqXHR, textStatus, errorThrown) ->
        $('body').append "AJAX Error: #{textStatus}"
      success: (data, textStatus, jqXHR) ->
        $('#info').empty().append "BatchOp2: Successful AJAX call: #{data.usrname}"

