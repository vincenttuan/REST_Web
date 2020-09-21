<!-- https://ithelp.ithome.com.tw/articles/10187474 -->
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="work" required="true" rtexprvalue="true" %>
<%@attribute name="eat" required="true" rtexprvalue="true" %>
<%@attribute name="commute" required="true" rtexprvalue="true" %>
<%@attribute name="tv" required="true" rtexprvalue="true" %>
<%@attribute name="sleep" required="true" rtexprvalue="true" %>
<%@tag body-content="scriptless"%> <!-- scriptless(預設)、empty、tagdependent -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Work', ${work}],
            ['Eat', ${eat}],
            ['Commute', ${commute}],
            ['Watch TV', ${tv}],
            ['Sleep', ${sleep}]
        ]);

        var options = {
            title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
</script>
<div id="piechart" style="width: 900px; height: 500px;"></div>
<jsp:doBody/>