using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Squid : MonoBehaviour
{
    private Vector2 originalPosition;//Vị trí ban đầu
    public float speed; // Tốc độ di chuyển
    public float height; // Độ cao
    // Start is called before the first frame update
    void Start()
    {
        originalPosition = transform.position;
        StartCoroutine(GoUp());
    }
    IEnumerator GoUp()
    {
        //khối đi lên
        while (true)
        {
            transform.position = new Vector2(
               transform.position.x,
               transform.position.y + speed * Time.deltaTime);
            if (transform.position.y > originalPosition.y + height) break;
            yield return null;
        }
        StartCoroutine(GoDown());
    }
    IEnumerator GoDown()
    {
        bool stop = false;
        while (!stop)
        {
            stop = true;
            yield return new WaitForSeconds(2);
        }
        //Khối đi xuống
        while (true)
        {
            transform.position = new Vector2(
                transform.position.x,
                transform.position.y - speed * Time.deltaTime);
            if (transform.position.y < originalPosition.y)
            {
                transform.position = originalPosition;
                break;
            }
            yield return null;
        }
        StartCoroutine(GoUp());
    }
}


