using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class ScoreManger : MonoBehaviour
{
    private float time = 0f;
    private static int timeCount = 0;
    private static int scoreUser;
    private static int scoreTotal = 0;
    private static int monter1Count = 0;
    private static int monter2Count = 0;
    private static int monter3Count = 0;
    private static int healthPlayerMax = 400;
    private static int healthPlayerCurrent = 0;
    private Text txtTime;
    private Text txtPlayerName;
    private Text txtScore;
    private Text txtHealthPlayer;
    private Text txtMonter1;
    private Text txtMonter2;
    private Text txtMonter3;
    // Start is called before the first frame update
    void Start()
    {
        UserResponse userResponse = UserResponse.getInstance();
        scoreUser = userResponse.score;
        if (scoreTotal == 0)
            scoreTotal += scoreUser;
        if (healthPlayerCurrent == 0)
            healthPlayerCurrent = healthPlayerMax;

        txtTime = GameObject.Find("txtTime").GetComponent<Text>();
        txtPlayerName = GameObject.Find("txtPlayerName").GetComponent<Text>();
        txtScore = GameObject.Find("txtScore").GetComponent<Text>();
        txtHealthPlayer = GameObject.Find("txtHealthPlayer").GetComponent<Text>();
        txtMonter1 = GameObject.Find("txtMonter1").GetComponent<Text>();
        txtMonter2 = GameObject.Find("txtMonter2").GetComponent<Text>();
        txtMonter3 = GameObject.Find("txtMonter3").GetComponent<Text>();

        txtPlayerName.text = "Player: " + userResponse.name;
        txtScore.text = "Score: " + scoreUser;
    }

    // Update is called once per frame
    void Update()
    {
        time += Time.deltaTime;
        if (time >= 1f)
        {
            timeCount += (int)time;
            time = 0f;

            txtTime.text = timeCount + "s";
        }

        txtScore.text = "Score: " + scoreTotal;
        txtHealthPlayer.text = "Health: " + healthPlayerCurrent;
        txtMonter1.text = "x" + monter1Count;
        txtMonter2.text = "x" + monter2Count;
        txtMonter3.text = "x" + monter3Count;
    }
    public static int getMonter1Count()
    {
        return monter1Count;
    }
    public static void setMonter1Count()
    {
        monter1Count++;
        scoreTotal += 10;
    }
    public static int getMonter2Count()
    {
        return monter2Count;
    }
    public static void setMonter2Count()
    {
        monter2Count++;
        scoreTotal += 20;
    }
    public static int getMonter3Count()
    {
        return monter3Count;
    }
    public static void setMonter3Count()
    {
        monter3Count++;
        scoreTotal += 30;
    }
    public static int getHealthPlayerMax()
    {
        return healthPlayerMax;
    }
    public static void setHealthPlayerMax(int health)
    {
        healthPlayerMax = health;
    }
    public static int getHealthPlayerCurrent()
    {
        return healthPlayerCurrent;
    }
    public static void setHealthPlayerCurrent(int dame)
    {
        healthPlayerCurrent -= dame;
        Debug.Log("log health player");
    }

    public static int getScoreTotal()
    {
        return scoreTotal;
    }
}
