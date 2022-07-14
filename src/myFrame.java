import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class myFrame extends JFrame {
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    myFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,210);
        this.setLocationRelativeTo(null);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced",Font.PLAIN,70));
        timeLabel.setForeground(new Color(252, 177, 3));
        timeLabel.setBackground(new Color(252, 3, 248));
        timeLabel.setOpaque(true);

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Monospaced",Font.PLAIN,30));

        dateFormat = new SimpleDateFormat("       MMMMM dd,yyyy");
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Monospaced",Font.PLAIN,25));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {
        while (true){
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
