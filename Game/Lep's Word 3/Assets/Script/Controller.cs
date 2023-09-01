using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Controller : MonoBehaviour
{
    private int count = 3;
    public GameObject player;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(count-- > 0)
        {
            float position = Random.Range(-5f, 6f);
           GameObject qv = (GameObject) Instantiate(Resources.Load(("Prefabs/Monster")),
                new Vector3(position, -3.5f, 0), Quaternion.identity);
            qv.GetComponent<Animal>().SetStart(position - 5);
            qv.GetComponent<Animal>().SetEnd(position + 6);

            qv.GetComponent<Animal>().SetPlayer(player);

        }
    }
}
