using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class Player_Life : MonoBehaviour
{

    [SerializeField] private Slider slider;
    [SerializeField] private float addSpeedPlayer = 20f;

    private bool isHurtFromMonter = false;
    // Start is called before the first frame update
    void Start()
    {
        slider.maxValue = ScoreManger.getHealthPlayerMax();
    }

    // Update is called once per frame
    void Update()
    {
        slider.value = ScoreManger.getHealthPlayerCurrent();

        if (isHurtFromMonter)
        {
            ScoreManger.setHealthPlayerCurrent(1);
        }
    }

    void OnTriggerEnter2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("LoadScene2"))
        {
            SceneManager.LoadScene("Scene2");
        }
    }
    void OnCollisionEnter2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Monter"))
        {
            isHurtFromMonter = true;
        }
    }

    void OnCollisionExit2D(Collision2D collision2D)
    {
        if (collision2D.gameObject.CompareTag("Monter"))
        {
            isHurtFromMonter = false;
        }
    }
}
