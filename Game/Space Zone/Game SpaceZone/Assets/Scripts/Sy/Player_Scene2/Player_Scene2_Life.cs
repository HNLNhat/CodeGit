using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Player_Scene2_Life : MonoBehaviour
{
    [SerializeField] private Slider slider;
    private bool isHurtFromMonter = false;
    private bool isHurtFromBoss = false;
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
        else if (isHurtFromBoss)
        {
            ScoreManger.setHealthPlayerCurrent(2);
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

    void OnTriggerEnter2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Boss"))
        {
            isHurtFromBoss = true;
        }
    }

    void OnTriggerExit2D(Collider2D collider2D)
    {
        if (collider2D.CompareTag("Boss"))
        {
            isHurtFromBoss = false;
        }
    }
}
