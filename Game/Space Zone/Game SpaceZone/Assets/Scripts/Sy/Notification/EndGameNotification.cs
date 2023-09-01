using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class EndGameNotification : MonoBehaviour
{
    [SerializeField] private GameObject controll;
    [SerializeField] private GameObject boss;
    [SerializeField] private GameObject btnHome;
    [SerializeField] private GameObject btnExitGame;

    [SerializeField] private Text txtEndGame;
    [SerializeField] private Text txtNotification;
    private Boss_Movement boss_Movement;
    private string title = "END GAME";
    private string message;
    private bool isRun = false;
    // Start is called before the first frame update
    void Start()
    {
        boss_Movement = boss.GetComponent<Boss_Movement>();
    }

    // Update is called once per frame
    void Update()
    {
        if (!isRun)
        {
            if (ScoreManger.getHealthPlayerCurrent() <= 0)
            {
                controll.SetActive(true);
                message = "Defeat";
                StartCoroutine(Loading());
                StartCoroutine(ShowNotification(message));
            }
            else if (boss_Movement.getHealthBossCurrent() <= 0)
            {
                controll.SetActive(true);
                message = "You win";
                StartCoroutine(Loading());
                StartCoroutine(ShowNotification(message));
            }
        }
    }

    IEnumerator Loading()
    {
        isRun = true;
        txtEndGame.text = null;
        for (int i = 0; i < title.Length; i++)
        {
            txtEndGame.text += title[i];
            yield return new WaitForSeconds(0.02f);
        }
    }

    IEnumerator ShowNotification(string s)
    {
        txtNotification.text = null;
        for (int i = 0; i < s.Length; i++)
        {
            txtNotification.text += s[i];
            yield return new WaitForSeconds(0.02f);
        }
        yield return new WaitForSeconds(1f);
        Time.timeScale = 0;
        btnHome.SetActive(true);
        btnExitGame.SetActive(true);
    }


}
