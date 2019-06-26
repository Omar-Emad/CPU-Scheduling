package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;


public class Main extends Application implements EventHandler<ActionEvent> {
    RadioButton FCFC ;RadioButton SJFPreemtive ;RadioButton PriorityPremptive ;RadioButton RoundRobin ;
    RadioButton SJFNonPreemptive ;  RadioButton PriorityNonPreemptive ;
    ToggleGroup procsses ;GridPane main ;TextField nProcesses ;Button Confirm; Button Reset ;
    int nProcess ;TextField arrival;TextField burst;TextField priority ;TextField quantum ; Text Waiting;double Waitingtime;
    int Quantum ;Label p;Label q;GridPane GantChart =new GridPane() ;
    String Colors[]={"violet","cyan","white ","gold","coral"};
    DropShadow shadow = new DropShadow();
    @Override
    public void start(Stage primaryStage) throws Exception{

        main=new GridPane();
        main.setPadding(new Insets(30, 30, 30, 30));
        main.setVgap(10);
        main.setHgap(150);
        Label a=new Label("Choose Type of Scheduler :");
        a.setFont(new Font("Arial", 17));
        a.setStyle("-fx-text-fill: linear-gradient(#ce1212,#e0580f);");
        nProcesses=new TextField();
        Label l = new Label("Enter no of proccesses :");
        l.setFont(new Font("Arial", 17));
        l.setStyle("-fx-text-fill: linear-gradient(#ce1212,#e0580f);");
        FCFC=new RadioButton();
        FCFC.setText("FCFC");
        //FCFC.set
        FCFC.setOnAction(this);
        SJFPreemtive=new RadioButton();
        SJFPreemtive.setText("SJF (Preemptive)");
        SJFPreemtive.setOnAction(this);
        SJFNonPreemptive=new RadioButton();
        SJFNonPreemptive.setText("SJF (NonPreemptive)");
        SJFNonPreemptive.setOnAction(this);
        PriorityPremptive=new RadioButton();
        PriorityPremptive.setText("Priority (Preemptive)");
        PriorityPremptive.setOnAction(this);
        PriorityNonPreemptive=new RadioButton();
        PriorityNonPreemptive.setText("Priority (NonPreemptive)");
        PriorityNonPreemptive.setOnAction(this);
        RoundRobin=new RadioButton();
        RoundRobin.setText("Round Robin");
        RoundRobin.setOnAction(this);
        procsses=new ToggleGroup();
        FCFC.setToggleGroup(procsses);
        SJFPreemtive.setToggleGroup(procsses);
        SJFNonPreemptive.setToggleGroup(procsses);
        PriorityPremptive.setToggleGroup(procsses);
        PriorityNonPreemptive.setToggleGroup(procsses);
        RoundRobin.setToggleGroup(procsses);
        main.add(a,0,0);
        main.add(FCFC,0,1);
        main.add(SJFPreemtive,0,2);
        main.add(SJFNonPreemptive,0,3);
        main.add(PriorityPremptive,0,4);
        main.add(PriorityNonPreemptive,0,5);
        main.add(RoundRobin,0,6);
        GridPane.setConstraints(l,0,8);
        main.getChildren().add(l);
        GridPane.setConstraints(nProcesses,0,9);
        main.getChildren().add(nProcesses);
        Confirm=new Button();
        Reset=new Button("Reset");
        Reset.setOnAction(this);
        Confirm.setOnAction(this);
        Confirm.setText("Start Simulation");
        GridPane.setConstraints(Confirm,0,18);
        main.getChildren().add(Confirm);
        main.add(Reset,1,18);
        primaryStage.setTitle("The Scheduler");
        main.setStyle("-fx-background-color: #383535;");
        primaryStage.setScene(new Scene(main,800,550));


        primaryStage.show();
        Label r = new Label("Arrival Time :");
        Label b = new Label("Burst Time :");
        p = new Label("priority :");
        q = new Label("Quantum Number :");
        main.add(r, 1, 2);
        main.add(b, 1, 4);
        main.add(p, 1, 6);
        main.add(q, 1, 8);
        arrival=new TextField();
        burst=new TextField();
        priority=new TextField();
        quantum=new TextField();
        GridPane.setConstraints(arrival,1,3);
        main.getChildren().add(arrival);
        GridPane.setConstraints(burst,1,5);
        main.getChildren().add(burst);
        GridPane.setConstraints(priority,1,7);
        main.getChildren().add(priority);
        priority.setEditable(false);
        GridPane.setConstraints(quantum,1,9);
        main.getChildren().add(quantum);
        quantum.setEditable(false);
        Label label = new Label("Each process should be followed by ' , '");
        label.setFont(new Font("Arial", 18));
        label.setStyle("-fx-text-fill: linear-gradient(#ce1212,#e0580f);");
        main.add(label,1,0);

//======================================================================================================================
        Confirm.setStyle("-fx-font: 18 arial; -fx-background-color: linear-gradient(#db2020,#5b1818) ;  -fx-text-fill: #1c1b1b; -fx-background-radius: 7;");
        Reset.setStyle("-fx-font: 18 arial; -fx-background-color: linear-gradient(#db2020,#5b1818) ;  -fx-text-fill: #1c1b1b; -fx-background-radius: 7;");
        r.setStyle("-fx-font-size: 14; -fx-text-fill: #2bc631;");
        b.setStyle("-fx-text-fill: #1bc6d6; -fx-font-size: 14;");
        p.setStyle("-fx-text-fill: #dee520; -fx-font-size: 14;");
        q.setStyle("-fx-text-fill: #de30f2; -fx-font-size: 14;");
        FCFC.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        SJFNonPreemptive.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        SJFPreemtive.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        PriorityNonPreemptive.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        PriorityPremptive.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        RoundRobin.setStyle("-fx-text-fill: #3961e5; -fx-font-size: 14;");
        arrival.setStyle("-fx-font-size: 13;");
        burst.setStyle("-fx-font-size: 13;");
        quantum.setStyle("-fx-font-size: 13; -fx-background-color: #968d8d;");
        priority.setStyle("-fx-font-size: 13; -fx-background-color: #968d8d;");
        nProcesses.setStyle("-fx-font-size: 13;");
        arrival.setPromptText("ex : 5,3,7,10");
        burst.setPromptText("ex : 5,3,7,10");

        Confirm.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Confirm.setEffect(shadow);
                    }
                });
        Confirm.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Confirm.setEffect(null);
                    }
                });
        Reset.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Reset.setEffect(shadow);
                    }
                });
        Reset.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        Reset.setEffect(null);
                    }
                });
    }
    public void sort( Process  A[],String t)
    {   int sortings;
        Process temp ;
        if(t=="FCFC")
        {
            while(true)
            {
                sortings=0;
                for (int i = 0; i < A.length-1 ; i++) {
                    if(A[i].getArrival()>A[i+1].getArrival())
                    {
                        temp=A[i+1];
                        A[i+1]=A[i] ;
                        A[i]=temp ;
                        sortings++;

                    }
                }
                if(sortings==0)break ;
            }

        }
        else  if(t=="Priority")
        {
            while(true)
            {
                sortings=0;
                for (int i = 0; i < A.length-1 ; i++) {
                    if(A[i].getPriority()>A[i+1].getPriority())
                    {
                        temp=A[i+1];
                        A[i+1]=A[i] ;
                        A[i]=temp ;
                        sortings++;

                    }
                }
                if(sortings==0)break ;
            }

        }
        else   if(t=="SJF")
        {
            while(true)
            {
                sortings=0;
                for (int i = 0; i < A.length-1 ; i++) {
                    if(A[i].getBurst()>A[i+1].getBurst())
                    {
                        temp=A[i+1];
                        A[i+1]=A[i] ;
                        A[i]=temp ;
                        sortings++;

                    }
                }
                if(sortings==0)break ;
            }

        }

    }
    public double nextArrive (Process A [])
    {
        double min=-1;
        int i=0;
        for(;i<A.length;i++)
        {
            if(!isFinished(A[i])) {
                min = A[i].getArrival();
                break;
            }
        }
        for(;i<A.length;i++)
        {
            if(A[i].getArrival()<min&&!isFinished(A[i]))
                min=A[i].getArrival();
        }
        return min;
    }
    public boolean isArrived(Process p,double time)
    {
        if(time>=p.getArrival()) return true;
        else return false ;
    }
    public boolean isFinished(Process p)
    {
        if(p.getBurst()<=0)return true ;
        else return  false;
    }
    public boolean isAboutToFinish(Process p,int q)
    {
        if(p.getBurst()<=q && p.getBurst()>0)return true ;
        else return false;
    }
    @Override
    public void handle(ActionEvent event) {

        if (event.getSource() == Confirm) {
            try {
                nProcess = Integer.parseInt(nProcesses.getText());
            } catch (NumberFormatException e) {
                nProcess = 0;
            }
            main.getChildren().remove(Waiting);
            Waitingtime=0 ;
            main.getChildren().remove(GantChart);
            GantChart = new GridPane();
            Process AllProcesses[] = new Process[nProcess];
            double Burstsum = 0;
            String a = "", p = "", b = "";
            int i = 0, aa = 0, pp = 0, bb = 0;
            while (i < nProcess) {
                if (aa < arrival.getText().length()) {
                    if (arrival.getText().charAt(aa) == ',') ;
                    else {
                        a = a + arrival.getText().charAt(aa);
                        aa++;
                    }
                }
                if (bb < burst.getText().length()) {
                    if (burst.getText().charAt(bb) == ',') ;
                    else {
                        b = b + burst.getText().charAt(bb);
                        bb++;
                    }
                }
                if (priority.getText().length() > 0 ) {
                    if(pp<priority.getText().length()) {
                        if (priority.getText().charAt(pp) == ',') ;
                        else {
                            p = p + priority.getText().charAt(pp);
                            pp++;
                        }
                    }
                    if (aa < arrival.getText().length() && bb < burst.getText().length() && (pp < priority.getText().length())) {
                        if (arrival.getText().charAt(aa) == ',' && burst.getText().charAt(bb) == ',' && priority.getText().charAt(pp) == ',') {
                            AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(p), i + 1);
                            Burstsum += Double.parseDouble(b);
                            i++;
                            bb++;
                            aa++;
                            pp++;
                            a = "";
                            b = "";
                            p = "";
                        }
                    }
                } else {
                    if (aa < arrival.getText().length() && bb < burst.getText().length()) {
                        if (arrival.getText().charAt(aa) == ',' && burst.getText().charAt(bb) == ',') {
                            AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), i + 1);
                            i++;
                            Burstsum += Double.parseDouble(b);
                            bb++;
                            aa++;
                            a = "";
                            b = "";
                        }
                    }
                }
                if ((i == nProcess - 1) && aa >= arrival.getText().length() && bb >= burst.getText().length() && (pp >= priority.getText().length() || pp == 0)) {

                    if (priority.getText().length() > 0) {
                        AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(p), i + 1);
                        Burstsum += Double.parseDouble(b);
                    } else {
                        AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), i + 1);
                        Burstsum += Double.parseDouble(b);
                    }
                    break;
                }

            }
            if (priority.getText().length() > 0) {
                AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(p), i+1);
                Burstsum += Double.parseDouble(b);
            } else {
                AllProcesses[i] = new Process(Double.parseDouble(a), Double.parseDouble(b), i+1);
                Burstsum += Double.parseDouble(b);
            }
            if (quantum.getText().length() > 0) Quantum = Integer.parseInt(quantum.getText());

//==================================== FCFS ====================================================================================

            double timeline = 0;
            if (FCFC.isSelected()) {
                sort(AllProcesses, "FCFC");
                i = 0;
                int k = 0;
                for (int j = 0; j < AllProcesses.length; j++) {
                    if (!isArrived(AllProcesses[j], timeline)) {
                        Label IDLE = new Label("Idle \n " + timeline + "\n to \n" + (AllProcesses[j].getArrival()));
                        IDLE.setStyle("-fx-background-color: " + Colors[4] + "; -fx-padding: 10px;");
                        Burstsum += AllProcesses[j].getArrival() - timeline;
                        IDLE.setMinWidth((AllProcesses[j].getArrival() - timeline) * 500 / Burstsum);
                        GantChart.add(IDLE, k, 0);
                        k++;
                        timeline = AllProcesses[j].getArrival();
                        j--;
                        continue;
                    }
                    Label label = new Label("P" + AllProcesses[j].getProcessno() + "\n" + timeline + "\n to \n" + (timeline + AllProcesses[j].getBurst()));
                    Waitingtime+=(timeline-AllProcesses[j].getArrival());
                    label.setStyle("-fx-background-color: " + Colors[i] + "; -fx-padding: 10px;");
                    i = (i + 1) % 4;
                    label.setMinWidth(AllProcesses[j].getBurst() * (500 / Burstsum));
                    timeline += (AllProcesses[j].getBurst());
                    GantChart.add(label, k, 0);
                    k++;
                }
            }
//========================== SJF & Priority NonPreemptive ============================================================================================

            if (SJFNonPreemptive.isSelected() || PriorityNonPreemptive.isSelected() )
            {
                if(SJFNonPreemptive.isSelected())
                    sort(AllProcesses,"SJF");
                else
                    sort(AllProcesses,"Priority");
                int k = 0, j = 0, flag;
                while (true)
                {
                    flag=0;
                    for (i = 0; i < AllProcesses.length; i++)
                    {
                        if (AllProcesses[i].getArrival() <= timeline && !isFinished(AllProcesses[i]))
                        {
                            flag = 1;
                            Label label = new Label("P" + AllProcesses[i].getProcessno() + "\n" + timeline + "\n to \n" + (timeline + AllProcesses[i].getBurst()));
                            Waitingtime+=(timeline-AllProcesses[j].getArrival());
                            label.setStyle("-fx-background-color: " + Colors[j] + "; -fx-padding: 10px;");
                            j = (j + 1) % 4;
                            label.setMinWidth(AllProcesses[i].getBurst() * (500 / Burstsum));
                            timeline += (AllProcesses[i].getBurst());
                            AllProcesses[i].setBurst(0);
                            GantChart.add(label, k, 0);
                            k++;
                            break;
                        }
                    }
                    if(nextArrive(AllProcesses)==-1)
                        break;
                    if(flag==0)  //idle  ( there is no process arrived yet )
                    {
                        Label IDLE = new Label("Idle \n " + timeline + "\n to \n" + nextArrive(AllProcesses));
                        IDLE.setStyle("-fx-background-color: " + Colors[4] + "; -fx-padding: 10px;");
                        Burstsum += nextArrive(AllProcesses) - timeline;
                        IDLE.setMinWidth((nextArrive(AllProcesses) - timeline) * 500 / Burstsum);
                        GantChart.add(IDLE, k, 0);
                        k++;
                        timeline = nextArrive(AllProcesses);
                    }
                }
            }

//============================ Round Robin ============================================================================================

            if (RoundRobin.isSelected()) {
                sort(AllProcesses, "FCFC");
                i = 0;
                int k = 0;

                while (true) {
                    boolean allfinished = true ;
                    boolean allnotarrived=true ;
                    for (int j = 0; j < AllProcesses.length; j++) {
                        if(isFinished(AllProcesses[j]))continue ;
                        allfinished=false;



                        if(isArrived(AllProcesses[j],timeline)&&!isFinished(AllProcesses[j])) {
                            allnotarrived = false;
                            if (isAboutToFinish(AllProcesses[j], Quantum)) {

                                Label label = new Label("P" + AllProcesses[j].getProcessno() + "\n" + timeline + "\n to \n" + (timeline + AllProcesses[j].getBurst()));
                                label.setMinWidth(AllProcesses[j].getBurst() * (500 / Burstsum));
                                label.setStyle("-fx-background-color: " + Colors[i] + "; -fx-padding: 10px;");
                                i = (i + 1) % 4;
                                timeline += (AllProcesses[j].getBurst());
                                Waitingtime+=(timeline-AllProcesses[j].getArrival()-AllProcesses[j].getBurst());
                                GantChart.add(label, k, 0);
                                k++;
                                AllProcesses[j].setBurst(0);
                            } else {
                                Label label = new Label("P" + AllProcesses[j].getProcessno() + "\n" + timeline + "\n to \n" + (timeline + Quantum));
                                label.setMinWidth(Quantum * (500 / Burstsum));
                                label.setStyle("-fx-background-color: " + Colors[i] + "; -fx-padding: 10px;");
                                i = (i + 1) % 4;
                                Waitingtime-=Quantum;
                                timeline += Quantum;
                                GantChart.add(label, k, 0);
                                AllProcesses[j].setBurst(AllProcesses[j].getBurst() - Quantum);
                                k++;
                            }
                        }

                    }
                    if (allnotarrived==true) {
                        for (int j = 0; j < AllProcesses.length; j++) {
                            if(!isFinished(AllProcesses[j])) {
                                Label IDLE = new Label("Idle \n " + timeline + "\n to \n" + (AllProcesses[j].getArrival()));
                                IDLE.setStyle("-fx-background-color: " + Colors[4] + "; -fx-padding: 10px;");
                                Burstsum += AllProcesses[j].getArrival() - timeline;
                                IDLE.setMinWidth((AllProcesses[j].getArrival() - timeline) * 500 / Burstsum);
                                GantChart.add(IDLE, k, 0);
                                k++;
                                timeline = AllProcesses[j].getArrival();
                                break ;
                            }
                        }



                    }
                    if(allfinished==true)break;
                }

            }
//==================== non preemptive =======================================================================================
            if(SJFPreemtive.isSelected())
            {

                Process AllProcessesFCFC[]= Arrays.copyOf(AllProcesses,AllProcesses.length);

                sort(AllProcessesFCFC,"FCFC");

                i = 0;
                int k = 0;



                while (true) {
                    sort(AllProcesses, "SJF");
                    boolean allnotarrived = true;
                    boolean again = false;
                    boolean allfinished = true;
                    for (int j = 0; j < AllProcesses.length; j++) {
                        if(isFinished(AllProcesses[j]))continue ;
                        allfinished=false;
                        if (isArrived(AllProcesses[j],timeline)) {
                            double oldtimeline=timeline ;
                            timeline++;
                            while((timeline-oldtimeline)<AllProcesses[j].getBurst())
                            {   boolean arrived=false ;
                                for (int l = 0; l <j ; l++) {
                                    if(isArrived(AllProcesses[l],timeline)&&!isFinished(AllProcesses[l])){arrived=true ;break;}

                                }
                                if(arrived==true)break;
                                timeline++;
                            }

                            Label label = new Label("P" + AllProcesses[j].getProcessno() + "\n" + oldtimeline + "\n to \n" + timeline);
                            label.setStyle("-fx-background-color: " + Colors[i] + "; -fx-padding: 10px;");
                            i = (i + 1) % 4;
                            label.setMinWidth((timeline-oldtimeline) * (500 / Burstsum));
                            GantChart.add(label, k, 0);
                            Waitingtime-=((timeline-oldtimeline));
                            AllProcesses[j].setBurst(AllProcesses[j].getBurst()-((timeline-oldtimeline)));
                            if(isFinished(AllProcesses[j])){Waitingtime+=(timeline-AllProcesses[j].getArrival());}
                            k++;
                            allnotarrived=false ;
                            if(again==true)break ;
                        }
                        else {again=true ;}
                    }

                    if (allnotarrived==true) {
                        for (int j = 0; j < AllProcesses.length; j++) {
                            if(!isFinished(AllProcessesFCFC[j])) {
                                Label IDLE = new Label("Idle \n " + timeline + "\n to \n" + (AllProcessesFCFC[j].getArrival()));
                                IDLE.setStyle("-fx-background-color: " + Colors[4] + "; -fx-padding: 10px;");
                                Burstsum += AllProcessesFCFC[j].getArrival() - timeline;
                                IDLE.setMinWidth((AllProcessesFCFC[j].getArrival() - timeline) * 500 / Burstsum);
                                GantChart.add(IDLE, k, 0);
                                k++;
                                timeline = AllProcessesFCFC[j].getArrival();
                                break ;
                            }
                        }
                    }
                    if(allfinished==true)break;
                }

            }
            if(PriorityPremptive.isSelected())
            {
                Process AllProcessesFCFC[]= Arrays.copyOf(AllProcesses,AllProcesses.length);

                sort(AllProcessesFCFC,"FCFC");

                i = 0;
                int k = 0;



                while (true) {
                    sort(AllProcesses, "Priority");
                    boolean allnotarrived = true;
                    boolean again = false;
                    boolean allfinished = true;
                    for (int j = 0; j < AllProcesses.length; j++) {
                        if(isFinished(AllProcesses[j]))continue ;
                        allfinished=false;
                        if (isArrived(AllProcesses[j],timeline)) {
                            double oldtimeline=timeline ;
                            timeline++;
                            while((timeline-oldtimeline)<AllProcesses[j].getBurst())
                            {   boolean arrived=false ;
                                for (int l = 0; l <j ; l++) {
                                    if(isArrived(AllProcesses[l],timeline)&&!isFinished(AllProcesses[l])){arrived=true ;break;}

                                }
                                if(arrived==true)break;
                                timeline++;
                            }

                            Label label = new Label("P" + AllProcesses[j].getProcessno() + "\n" + oldtimeline + "\n to \n" + timeline);
                            label.setStyle("-fx-background-color: " + Colors[i] + "; -fx-padding: 10px;");
                            i = (i + 1) % 4;
                            label.setMinWidth((timeline-oldtimeline) * (500 / Burstsum));
                            GantChart.add(label, k, 0);
                            Waitingtime-=((timeline-oldtimeline));
                            AllProcesses[j].setBurst(AllProcesses[j].getBurst()-((timeline-oldtimeline)));
                            if(isFinished(AllProcesses[j])){Waitingtime+=(timeline-AllProcesses[j].getArrival());}
                            k++;
                            allnotarrived=false ;
                            if(again==true)break ;
                        }
                        else {again=true ;}
                    }

                    if (allnotarrived==true) {
                        for (int j = 0; j < AllProcesses.length; j++) {
                            if(!isFinished(AllProcessesFCFC[j])) {
                                Label IDLE = new Label("Idle \n " + timeline + "\n to \n" + (AllProcessesFCFC[j].getArrival()));
                                IDLE.setStyle("-fx-background-color: " + Colors[4] + "; -fx-padding: 10px;");
                                Burstsum += AllProcessesFCFC[j].getArrival() - timeline;
                                IDLE.setMinWidth((AllProcessesFCFC[j].getArrival() - timeline) * 500 / Burstsum);
                                GantChart.add(IDLE, k, 0);
                                k++;
                                timeline = AllProcessesFCFC[j].getArrival();
                                break ;
                            }
                        }
                    }
                    if(allfinished==true)break;
                }
            }
//===========================================================================================================================
            /*Waiting=new Text("The Waiting Time is :"+(Waitingtime/nProcess));
            main.add(GantChart, 0, 18);
            main.add(Waiting,0,19);*/

            SecWindow.display(GantChart,(Waitingtime/nProcess));
        }

        if(event.getSource()==Reset) {
            nProcesses.clear();
            arrival.clear();
            priority.clear();
            burst.clear();
            quantum.clear();
        }

        if ( PriorityPremptive.isSelected() || PriorityNonPreemptive.isSelected()) {
            priority.setEditable(true);
            priority.setStyle("-fx-font-size: 13; -fx-background-color: #fccfc;");
            priority.setPromptText("ex : 5,3,7,10");
        } else {
            priority.setEditable(false);
            priority.clear();
            priority.setStyle("-fx-font-size: 13; -fx-background-color: #968d8d;");
            priority.setPromptText("");

        }
        if ( RoundRobin.isSelected()) {
            quantum.setEditable(true);
            quantum.setStyle("-fx-font-size: 13; -fx-background-color: #fccfc;");
        } else {
            quantum.setEditable(false);
            quantum.clear();
            quantum.setStyle("-fx-font-size: 13; -fx-background-color: #968d8d;");
            quantum.setPromptText("");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

//===================== process class ==============================================================================

class Process {
    double arrival ;
    double priority ;
    double burst ;
    int Processno ;

    public Process(double arrival, double burst, double priority,int Processno) {
        this.arrival = arrival;
        this.priority = priority;
        this.burst = burst;
        this.Processno=Processno;
    }

    public Process(double arrival, double burst,int Processno) {
        this.arrival = arrival;
        this.burst = burst;
        this.Processno=Processno;
        priority=0;
    }

    public int getProcessno() {
        return Processno;
    }

    public void setProcessno(int processno) {
        Processno = processno;
    }

    public Process() {
        priority=0;
    }

    public double getArrival() {
        return arrival;
    }

    public void setArrival(double arrival) {
        this.arrival = arrival;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public double getBurst() {
        return burst;
    }

    public void setBurst(double burst) {
        this.burst = burst;
    }

    @Override
    public String toString() {
        return "Process{" +
                "arrival=" + arrival +
                ", priority=" + priority +
                ", burst=" + burst +
                '}';
    }
}

//============== window of gantt chart =============================================================================
class SecWindow {

    public static void display(GridPane gant,double waiting)
    {
        Stage window= new Stage() ;
        Scene scene;
        Label l = new Label("Average waiting time : "+waiting);
        l.setStyle(" -fx-font-size : 17; -fx-text-fill : #c208db");

        GridPane grid=new GridPane();
        grid.setStyle("-fx-background-color: #383535;");
        window.setTitle("Gantt Chart");

        grid.setPadding(new Insets(30,30,30,30));
        grid.setVgap(30);

        grid.add(gant,0,2);
        grid.add(l,0,3);

        scene = new Scene(grid);
        window.setScene(scene);
        window.show();

    }
}